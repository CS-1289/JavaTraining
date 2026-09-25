package com.training.ioapp.student.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.training.ioapp.student.model.Student;

public class CsvParser implements Parser {

    @Override
    public List<Student> parse(Path file) throws IOException {
        List<Student> students = new ArrayList<Student>();
        List<String> lines = Files.readAllLines(file);

        for (int index = 1; index < lines.size(); index++) {
            String[] values = lines.get(index).split(",", -1);
            if (values.length != 5) {
                throw new IOException("Invalid CSV row at line " + (index + 1));
            }
            students.add(new Student(
                    Integer.parseInt(values[0].trim()),
                    values[1].trim(),
                    values[2].trim(),
                    values[3].trim(),
                    values[4].trim()));
        }
        return students;
    }
}
