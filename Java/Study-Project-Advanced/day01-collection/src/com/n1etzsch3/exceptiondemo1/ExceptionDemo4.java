package com.n1etzsch3.exceptiondemo1;

import java.util.Scanner;

public class ExceptionDemo4 {
    public static void main(String[] args) {
        while (true) {
            try {
                double price = userInputPrice();
                System.out.println("Price entered: " + price);
                break;
            } catch (Exception e) {
                // e.printStackTrace();
                System.out.println("Invalid input. Please enter a valid price.");
            }
        }
    }

    public static double userInputPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a price:");
        double price = sc.nextDouble();
        return price;
    }
}
