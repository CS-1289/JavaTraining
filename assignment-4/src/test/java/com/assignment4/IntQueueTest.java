package com.assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntQueueTest {
    @Test
    void queueShouldEnqueueDequeueAndWrapAround() {
        IntQueue queue = new IntQueue(2);
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.peek());
        assertEquals(10, queue.dequeue());
        queue.enqueue(30);
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void queueShouldRejectInvalidOperations() {
        IntQueue queue = new IntQueue(1);
        assertThrows(IllegalStateException.class, queue::dequeue);
        queue.enqueue(1);
        assertThrows(IllegalStateException.class, () -> queue.enqueue(2));
    }
}
