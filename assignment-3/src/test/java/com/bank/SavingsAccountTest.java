package com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SavingsAccountTest {
    private SavingsAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount("S101", "Ravi", 10_000, 6.5, 2_000);
    }

    @Test
    void accountCreationShouldSetDetails() {
        assertEquals("S101", account.getAccountNumber());
        assertEquals("Ravi", account.getHolderName());
        assertEquals(10_000, account.getBalance());
    }

    @Test
    void depositValidAmountShouldIncreaseBalance() {
        account.deposit(2_000);
        assertEquals(12_000, account.getBalance());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -100, -1_000})
    void invalidDepositShouldBeRejected(double amount) {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(amount));
        assertEquals(10_000, account.getBalance());
    }

    @Test
    void withdrawShouldMaintainMinimumBalance() {
        account.withdraw(8_000);
        assertEquals(2_000, account.getBalance());
    }

    @Test
    void withdrawalBelowMinimumBalanceShouldBeRejected() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(8_001));
        assertEquals(10_000, account.getBalance());
    }

    @Test
    void interestShouldBeCalculatedCorrectly() {
        SavingsAccount interestAccount = new SavingsAccount("S102", "Ravi", 20_000, 6, 2_000);
        assertEquals(1_200, interestAccount.calculateInterest(), 0.001);
    }
}
