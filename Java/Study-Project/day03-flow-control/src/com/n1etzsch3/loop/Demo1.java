package com.n1etzsch3.loop;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number = scanner.nextInt();
        isPrime(number);
    }

    public static void isPrime(int n){
        int i;
        for(i = 2; i*i <= n; i++){
            if(n % i == 0) break;
        }
        if(i * i > n){
            System.out.println(n + " is prime number");
            return;
        }
        System.out.println(n + " is not prime number");
    }


}
