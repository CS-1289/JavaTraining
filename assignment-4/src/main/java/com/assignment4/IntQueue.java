package com.assignment4;

public class IntQueue {
    private final int[] values;
    private int front;
    private int rear;
    private int size;

    public IntQueue(int capacity) {
        values = new int[capacity];
    }

    public void enqueue(int value) {
        if (isFull()) throw new IllegalStateException("Queue is full");
        values[rear] = value;
        rear = (rear + 1) % values.length;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        int value = values[front];
        front = (front + 1) % values.length;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return values[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == values.length;
    }
}
