package com.assignment1;

import java.util.Scanner;

public class PyramidProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rows: ");
        int rows = scanner.nextInt();
        for (int i = 1; i <= rows; i++) {
            System.out.println(" ".repeat(rows - i) + "* ".repeat(i));
        }
    }
}
