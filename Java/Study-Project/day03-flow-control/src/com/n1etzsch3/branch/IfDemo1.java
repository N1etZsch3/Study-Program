package com.n1etzsch3.branch;

import java.util.Scanner;

public class IfDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an your age: ");
        int age = sc.nextInt();
        test1(age);
    }

    public static void test1(int age){
        if (age >= 18){
            System.out.println("You can surf the internet");
        }
        else System.out.println("You can not surf the internet");
    }

}
