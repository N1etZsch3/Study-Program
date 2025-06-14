package com.n1etzsch3.branch;

import java.util.Scanner;

public class SwitchDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入分数：");
        int grade = scanner.nextInt();
        test1(grade);
    }

    public static void test1(int grade){
        // 根据分数输出等级
        switch(grade){
            case 90:
                System.out.println("A");
                break;
            case 80:
                System.out.println("B");
                break;
            case 70:
                System.out.println("C");
                break;
            case 60:
                System.out.println("D");
                break;
            default:
                System.out.println("E");
        }
    }
}
