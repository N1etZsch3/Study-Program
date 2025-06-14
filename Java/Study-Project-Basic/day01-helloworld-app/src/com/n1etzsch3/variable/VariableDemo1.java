package com.n1etzsch3.variable;

public class VariableDemo1 {
    public static void main(String[] args) {
        printVariable();
    }
    public static void printVariable() {
        // Declare and initialize a variable
        int number = 42;
        String message = "Hello, World!";
        double pi = 3.14;
        boolean isJavaFun = true;
        char initial = 'N';

        // Print the variable
        System.out.println("Number: " + number);
        System.out.println("Message: " + message);
        System.out.println("Pi: " + pi);
        System.out.println("Is Java fun? " + isJavaFun);
        System.out.println("Initial: " + initial);
    }
}
