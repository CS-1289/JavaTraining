package com.training.ioapp.student.parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import com.training.ioapp.student.model.Student;

public interface Parser {

    List<Student> parse(Path file) throws IOException;
}
