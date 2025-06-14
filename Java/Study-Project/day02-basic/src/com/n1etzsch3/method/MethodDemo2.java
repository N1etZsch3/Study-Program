package com.n1etzsch3.method;

public class MethodDemo2 {
    public static void main(String[] args) {

    }
    public static void print(int a, int b){
        System.out.println(a);
        System.out.println(b);
    }

    public static void print(String c){
        System.out.println(c);
    }

    public static void print(String d, int a, int b){
        System.out.println(d);
        System.out.println(a);
        System.out.println(b);
    }

    // 需求：发射火箭，指定位置
    public static void fire(int x, int y){
        System.out.println("发射火箭，指定位置：" + x + "," + y);
    }

    //定义一个重载方法
    public static void fire(String c){
        System.out.println("发射火箭，指定位置：" + c);
    }
}
