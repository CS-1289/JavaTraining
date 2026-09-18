package com.assignment4;

public final class BracketChecker {
    private BracketChecker() {
    }

    public static boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>(expression.length());
        for (char character : expression.toCharArray()) {
            if ("([{".indexOf(character) >= 0) stack.push(character);
            if (")]}".indexOf(character) >= 0) {
                if (stack.isEmpty() || !matches(stack.pop(), character)) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return open == '(' && close == ')' || open == '[' && close == ']' || open == '{' && close == '}';
    }
}
