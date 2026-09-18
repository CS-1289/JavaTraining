package com.assignment4;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private final ArrayList<T> values = new ArrayList<>();
    private final int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public void push(T value) {
        if (isFull()) throw new IllegalStateException("Stack is full");
        values.add(value);
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return values.remove(values.size() - 1);
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return values.get(values.size() - 1);
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public boolean isFull() {
        return values.size() == capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = values.size() - 1;

            public boolean hasNext() {
                return index >= 0;
            }

            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return values.get(index--);
            }
        };
    }
}
