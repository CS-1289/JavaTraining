package com.training.ioapp.student.parser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.training.ioapp.student.model.Student;

public class JsonParser implements Parser {

    private static final Pattern OBJECT = Pattern.compile("\\{([^{}]+)\\}");

    @Override
    public List<Student> parse(Path file) throws IOException {
        String content = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
        List<Student> students = new ArrayList<Student>();
        Matcher objects = OBJECT.matcher(content);

        while (objects.find()) {
            String student = objects.group(1);
            students.add(new Student(
                    Integer.parseInt(value(student, "id")),
                    value(student, "firstName"),
                    value(student, "lastName"),
                    value(student, "email"),
                    value(student, "course")));
        }

        if (students.isEmpty()) {
            throw new IOException("No student records found in JSON file");
        }
        return students;
    }

    private String value(String json, String field) throws IOException {
        Pattern fieldPattern = Pattern.compile("\"" + field + "\"\\s*:\\s*(?:\"([^\"]*)\"|(\\d+))");
        Matcher matcher = fieldPattern.matcher(json);
        if (!matcher.find()) {
            throw new IOException("Missing field: " + field);
        }
        return matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
    }
}
