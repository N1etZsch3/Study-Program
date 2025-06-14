package com.n1etzsch3.exceptiondemo1;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        System.out.println(divide(10, 0));
        System.out.println(divide(2, 3));
    }

    // 异常作为一种特殊的返回值
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return a / b;
    }
}
