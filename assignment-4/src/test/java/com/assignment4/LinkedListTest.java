package com.assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LinkedListTest {
    @Test
    void listShouldAddInsertDeleteAndIterate() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("D");
        list.insert(2, "C");

        Iterator<String> iterator = list.iterator();
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertEquals("D", iterator.next());
        assertFalse(iterator.hasNext());
        assertEquals("C", list.delete(2));
        assertEquals(3, list.size());
    }

    @Test
    void listShouldValidateIndexes() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(0));
    }
}
