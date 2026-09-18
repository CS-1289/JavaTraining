package com.assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GenericStackTest {
    @Test
    void genericStackShouldStoreEmployeeObjects() {
        Stack<Employee> stack = new Stack<>(2);
        Employee employee = new Employee(1, "Ravi");
        stack.push(employee);
        assertEquals(employee, stack.peek());
        assertEquals(employee, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
