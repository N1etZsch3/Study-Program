package com.n1etzsch3.demo1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 生成五个学生对象
        Student[] students = new Student[5];
        students[0] = new Student("张三", "男", 85.5);
        students[1] = new Student("李四", "女", 90.0);
        students[2] = new Student("王五", "男", 78.0);
        students[3] = new Student("赵六", "女", 88.5);
        students[4] = new Student("钱七", "男", 92.0);

        Scheme sc = getSchene();
        if (sc != null) {
            sc.showAllStudentsInfo(students);
            sc.showAverageScore(students);
        }
        else System.out.println("输入有误！");
    }

    public static Scheme getSchene(){
        System.out.println("请选择实现方案：(1、基础\\2、高级)");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        return switch (option) {
            case 1 -> new Scheme1();
            case 2 -> new Scheme2();
            default -> null;
        };
    }
}
