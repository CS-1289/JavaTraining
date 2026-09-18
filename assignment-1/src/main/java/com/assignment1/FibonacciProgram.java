package com.assignment1;

import java.util.Scanner;

public class FibonacciProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of terms: ");
        System.out.println(MathExercises.fibonacci(scanner.nextInt()));
    }
}
