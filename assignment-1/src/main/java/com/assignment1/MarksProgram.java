package com.assignment1;

import java.util.Scanner;

public class MarksProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Math, science and English marks: ");
        double percentage = MathExercises.percentage(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.printf("Percentage: %.2f%nGrade: %s%n", percentage, MathExercises.grade(percentage));
    }
}
