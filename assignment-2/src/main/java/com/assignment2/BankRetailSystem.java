package com.assignment2;

import java.util.Arrays;

public class BankRetailSystem {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        manager.addAccount(new Account("A101", "Ravi", 10_000, 1234, "ACTIVE"));
        manager.depositTransaction("A101", 1234, 2_000);
        manager.withdrawTransaction("A101", 1234, 3_000);
        System.out.println("Balance: " + manager.showBalance("A101", 1234));

        int[] numbers = {5, 2, 9, 1, 3};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
