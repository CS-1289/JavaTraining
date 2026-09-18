package com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrentAccountTest {
    private CurrentAccount account;

    @BeforeEach
    void setUp() {
        account = new CurrentAccount("C101", "Priya", 5_000, 10_000);
    }

    @Test
    void accountCreationShouldSetDetails() {
        assertEquals("C101", account.getAccountNumber());
        assertEquals("Priya", account.getHolderName());
        assertEquals(10_000, account.getOverdraftLimit());
    }

    @Test
    void withdrawShouldUseAvailableBalance() {
        account.withdraw(3_000);
        assertEquals(2_000, account.getBalance());
    }

    @Test
    void withdrawShouldAllowOverdraftWithinLimit() {
        account.withdraw(8_000);
        assertEquals(-3_000, account.getBalance());
    }

    @Test
    void withdrawShouldAllowMaximumOverdraft() {
        account.withdraw(15_000);
        assertEquals(-10_000, account.getBalance());
    }

    @Test
    void withdrawShouldRejectAmountBeyondOverdraftLimit() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(15_001));
        assertEquals(5_000, account.getBalance());
    }
}
