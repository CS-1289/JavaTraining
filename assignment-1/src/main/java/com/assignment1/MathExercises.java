package com.assignment1;

public final class MathExercises {
    private MathExercises() {
    }

    public static double area(double radius) {
        return Math.PI * radius * radius;
    }

    public static double perimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double netSalary(double basicSalary) {
        return basicSalary * 1.25;
    }

    public static double percentage(int math, int science, int english) {
        return (math + science + english) / 3.0;
    }

    public static String grade(double percentage) {
        if (percentage > 90) return "A+";
        if (percentage >= 75) return "A";
        if (percentage >= 60) return "B";
        if (percentage >= 50) return "C";
        return "F";
    }

    public static long factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("Number cannot be negative");
        long result = 1;
        for (int i = 2; i <= number; i++) result *= i;
        return result;
    }

    public static String fibonacci(int count) {
        if (count < 1) return "";
        StringBuilder series = new StringBuilder();
        int first = 0, second = 1;
        for (int i = 0; i < count; i++) {
            if (i > 0) series.append(' ');
            series.append(first);
            int next = first + second;
            first = second;
            second = next;
        }
        return series.toString();
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
