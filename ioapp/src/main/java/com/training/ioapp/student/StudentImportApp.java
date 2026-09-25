package com.training.ioapp.student;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import com.training.ioapp.student.dao.StudentDao;
import com.training.ioapp.student.model.Student;
import com.training.ioapp.student.parser.CsvParser;
import com.training.ioapp.student.parser.JsonParser;
import com.training.ioapp.student.parser.Parser;
import com.training.ioapp.student.parser.XmlParser;

public class StudentImportApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: StudentImportApp <csv|xml|json> <file-path>");
            return;
        }

        try {
            Parser parser = parserFor(args[0]);
            List<Student> students = parser.parse(Paths.get(args[1]));

            StudentDao studentDao = new StudentDao();
            studentDao.createTable();
            studentDao.saveAll(students);

            System.out.println(students.size() + " students saved.");
        } catch (IllegalArgumentException | IOException | SQLException exception) {
            System.out.println("Import failed: " + exception.getMessage());
        }
    }

    private static Parser parserFor(String type) {
        if ("csv".equalsIgnoreCase(type)) {
            return new CsvParser();
        }
        if ("xml".equalsIgnoreCase(type)) {
            return new XmlParser();
        }
        if ("json".equalsIgnoreCase(type)) {
            return new JsonParser();
        }
        throw new IllegalArgumentException("Supported types: csv, xml, json");
    }
}
