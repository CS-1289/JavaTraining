package com.assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntStackTest {
    @Test
    void stackShouldPushPeekAndPop() {
        IntStack stack = new IntStack(2);
        stack.push(10);
        stack.push(20);
        assertTrue(stack.isFull());
        assertEquals(20, stack.peek());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void stackShouldRejectInvalidOperations() {
        IntStack stack = new IntStack(1);
        assertThrows(IllegalStateException.class, stack::pop);
        stack.push(1);
        assertThrows(IllegalStateException.class, () -> stack.push(2));
        assertFalse(stack.isEmpty());
    }
}
