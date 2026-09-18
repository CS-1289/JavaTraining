package com.assignment4;

public class IntStack {
    private final int[] values;
    private int top = -1;

    public IntStack(int capacity) {
        values = new int[capacity];
    }

    public void push(int value) {
        if (isFull()) throw new IllegalStateException("Stack is full");
        values[++top] = value;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return values[top--];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return values[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == values.length - 1;
    }
}
