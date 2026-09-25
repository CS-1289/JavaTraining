package com.training.ioapp.student.model;

public class Student {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String course;

    public Student(int id, String firstName, String lastName, String email, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return id + " - " + firstName + " " + lastName + " (" + course + ")";
    }
}
