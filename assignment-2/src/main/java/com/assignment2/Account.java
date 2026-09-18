package com.assignment2;

public class Account {
    private String accountNumber;
    private String name;
    private double balance;
    private int accountPin;
    private String status;

    public Account() {
        this.status = "ACTIVE";
    }

    public Account(String accountNumber, String name, int accountPin) {
        this(accountNumber, name, 0, accountPin, "ACTIVE");
    }

    public Account(String accountNumber, String name, double balance, int accountPin, String status) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountPin = accountPin;
        this.status = status;
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = balance;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        setBalance(getBalance() + amount);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > getBalance()) return false;
        setBalance(getBalance() - amount);
        return true;
    }
}
