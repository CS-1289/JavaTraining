package com.assignment1;

import java.util.Scanner;

public class CircleProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Radius: ");
        double radius = scanner.nextDouble();
        System.out.printf("Area: %.2f%nPerimeter: %.2f%n", MathExercises.area(radius), MathExercises.perimeter(radius));
    }
}
