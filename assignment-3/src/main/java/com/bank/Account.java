package com.bank;

public abstract class Account {
    private final String accountNumber;
    private final String holderName;
    private double balance;

    protected Account(String accountNumber, String holderName, double balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    protected void updateBalance(double amount) {
        balance = amount;
    }

    public abstract void withdraw(double amount);

    public String displayAccountDetails() {
        return "%s - %s: %.2f".formatted(accountNumber, holderName, balance);
    }
}
