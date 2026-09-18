package com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FixedDepositAccountTest {
    @Test
    void accountCreationShouldSetDetails() {
        FixedDepositAccount account = new FixedDepositAccount("F101", "Amit", 50_000, 7.5, 3);
        assertEquals("F101", account.getAccountNumber());
        assertEquals("Amit", account.getHolderName());
        assertEquals(50_000, account.getBalance());
    }

    @Test
    void maturityAmountShouldBeCalculatedCorrectly() {
        FixedDepositAccount account = new FixedDepositAccount("F101", "Amit", 50_000, 7.5, 3);
        assertEquals(61_250, account.calculateMaturityAmount(), 0.001);
    }

    @Test
    void withdrawalShouldBeRejectedBeforeMaturity() {
        FixedDepositAccount account = new FixedDepositAccount("F101", "Amit", 50_000, 7.5, 3);
        assertThrows(UnsupportedOperationException.class, () -> account.withdraw(10_000));
        assertEquals(50_000, account.getBalance());
    }

    @Test
    void depositShouldIncreaseBalanceAccordingToDefinedRule() {
        FixedDepositAccount account = new FixedDepositAccount("F101", "Amit", 50_000, 7.5, 3);
        account.deposit(5_000);
        assertEquals(55_000, account.getBalance());
    }
}
