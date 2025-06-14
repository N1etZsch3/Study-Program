package com.n1etzsch3.method;

public class MethodDemo1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(getSum(a, b));
        System.out.println(getMax(a, b));

    }

    public static int getSum(int a, int b){
        return a+b;
    }

    public static int getMax(int a, int b){
        return a > b ? a : b;
    }

    public static void print(int a, int b){
        System.out.println(a);
        System.out.println(b);
    }

    public static void print(String c){
        System.out.println(c);
    }

    public static void print(double d, int a, int b){
        System.out.println(d);
        System.out.println(a);
        System.out.println(b);
    }

}
