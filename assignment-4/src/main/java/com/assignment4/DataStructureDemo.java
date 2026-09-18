package com.assignment4;

public class DataStructureDemo {
    public static void main(String[] args) {
        Stack<Employee> employees = new Stack<>(3);
        employees.push(new Employee(1, "Ravi"));
        employees.push(new Employee(2, "Priya"));

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());

        System.out.println(BracketChecker.isValid("[{a+b} * (c-d)]"));
    }
}
