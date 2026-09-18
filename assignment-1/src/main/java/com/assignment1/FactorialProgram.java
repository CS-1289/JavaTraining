package com.assignment1;

import java.util.Scanner;

public class FactorialProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        System.out.println("Factorial: " + MathExercises.factorial(scanner.nextInt()));
    }
}
