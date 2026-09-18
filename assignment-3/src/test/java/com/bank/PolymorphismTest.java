package com.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class PolymorphismTest {
    @Test
    void parentReferencesShouldUseCorrectWithdrawImplementation() {
        Account savings = new SavingsAccount("S101", "Ravi", 10_000, 6.5, 2_000);
        Account current = new CurrentAccount("C101", "Priya", 5_000, 10_000);
        Account fixedDeposit = new FixedDepositAccount("F101", "Amit", 50_000, 7.5, 3);

        savings.withdraw(5_000);
        current.withdraw(8_000);

        assertEquals(5_000, savings.getBalance());
        assertEquals(-3_000, current.getBalance());
        assertThrows(UnsupportedOperationException.class, () -> fixedDeposit.withdraw(10_000));
    }

    @Test
    void collectionShouldSupportAccountSpecificBehavior() {
        List<Account> accounts = List.of(
                new SavingsAccount("S101", "Ravi", 10_000, 6.5, 2_000),
                new CurrentAccount("C101", "Priya", 5_000, 10_000),
                new FixedDepositAccount("F101", "Amit", 50_000, 7.5, 3));

        accounts.forEach(account -> account.deposit(1_000));

        assertEquals(11_000, accounts.get(0).getBalance());
        assertEquals(6_000, accounts.get(1).getBalance());
        assertEquals(51_000, accounts.get(2).getBalance());
    }
}
