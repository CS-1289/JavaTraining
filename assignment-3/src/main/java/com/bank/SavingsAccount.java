package com.bank;

public class SavingsAccount extends Account {
    private final double interestRate;
    private final double minimumBalance;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate, double minimumBalance) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (getBalance() - amount < minimumBalance) throw new IllegalArgumentException("Minimum balance must be maintained");
        updateBalance(getBalance() - amount);
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}
