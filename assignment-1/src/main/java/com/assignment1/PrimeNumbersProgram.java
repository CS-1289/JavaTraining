package com.assignment1;

public class PrimeNumbersProgram {
    public static void main(String[] args) {
        for (int i = 1; i <= 10_000; i++) {
            if (MathExercises.isPrime(i)) System.out.println(i);
        }
    }
}
