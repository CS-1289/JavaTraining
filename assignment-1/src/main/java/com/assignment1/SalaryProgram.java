package com.assignment1;

import java.util.Scanner;

public class SalaryProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Basic salary: ");
        System.out.printf("Net salary: %.2f%n", MathExercises.netSalary(scanner.nextDouble()));
    }
}
