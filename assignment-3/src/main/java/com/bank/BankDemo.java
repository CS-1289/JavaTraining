package com.bank;

public class BankDemo {
    public static void main(String[] args) {
        Account[] accounts = {
                new SavingsAccount("S101", "Ravi", 10_000, 6.5, 2_000),
                new CurrentAccount("C101", "Priya", 5_000, 10_000),
                new FixedDepositAccount("F101", "Amit", 50_000, 7.5, 3)
        };

        for (Account account : accounts) {
            account.deposit(2_000);
            System.out.println(account.displayAccountDetails());
        }
    }
}
