package com.assignment1;

import java.util.Scanner;

public class PrimeCheckProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.println(number + (MathExercises.isPrime(number) ? " is prime" : " is not prime"));
    }
}
