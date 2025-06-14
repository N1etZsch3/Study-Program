package com.n1etzsch3.scanner;

import java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {
        printUserInfo();
    }

    public static void printUserInfo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String userName = sc.next();

        System.out.println("请输入年龄：");
        int userAge = sc.nextInt();

        System.out.println(userName + "的年龄为：" + userAge);

    }
}
