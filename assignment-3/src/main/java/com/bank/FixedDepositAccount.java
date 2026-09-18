package com.bank;

public class FixedDepositAccount extends Account {
    private final double interestRate;
    private final int tenureYears;

    public FixedDepositAccount(String accountNumber, String holderName, double balance, double interestRate, int tenureYears) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
        this.tenureYears = tenureYears;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTenureYears() {
        return tenureYears;
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawal is not allowed before maturity");
    }

    public double calculateMaturityAmount() {
        return getBalance() * (1 + interestRate * tenureYears / 100);
    }
}
