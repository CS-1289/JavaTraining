package com.assignment2;

public class AccountManager {
    private final Account[] accounts = new Account[5];

    public boolean addAccount(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return true;
            }
        }
        return false;
    }

    public boolean withdrawTransaction(String accountNumber, int pin, double amount) {
        Account account = findAccount(accountNumber, pin);
        return account != null && account.withdraw(amount);
    }

    public boolean depositTransaction(String accountNumber, int pin, double amount) {
        Account account = findAccount(accountNumber, pin);
        return account != null && account.deposit(amount);
    }

    public Double showBalance(String accountNumber, int pin) {
        Account account = findAccount(accountNumber, pin);
        return account == null ? null : account.getBalance();
    }

    private Account findAccount(String accountNumber, int pin) {
        for (Account account : accounts) {
            if (account != null && account.getAccountNumber().equals(accountNumber) && account.getAccountPin() == pin) {
                return account;
            }
        }
        return null;
    }
}
