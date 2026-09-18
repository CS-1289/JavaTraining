package com.assignment4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BracketCheckerTest {
    @Test
    void correctlyNestedBracketsShouldBeValid() {
        assertTrue(BracketChecker.isValid("[{a+b} * (c-d)]"));
    }

    @Test
    void incorrectlyNestedBracketsShouldBeInvalid() {
        assertFalse(BracketChecker.isValid("[((a-b} * (c-d)]]]"));
    }
}
