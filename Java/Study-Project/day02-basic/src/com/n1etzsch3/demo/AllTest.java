package com.n1etzsch3.demo;

import java.util.Scanner;

public class AllTest {

    public static class User {
        String name;
        boolean gender;
        int age;
        double weight;
        double height;
        double BMI;
        double BMR;
    }

    public static void main(String[] args) {
        User user = new User(); // ✅ 初始化对象
        getUserInfo(user);
        getBMI(user);
        getBMR(user);
        printUserInfo(user);
    }

    public static void getUserInfo(User user){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户姓名：");
        user.name = sc.nextLine();
        System.out.println("请输入用户性别(0为女性\\1为男性)：");
        user.gender = sc.nextBoolean(); // true 为男，false 为女
        System.out.println("请输入用户年龄：");
        user.age = sc.nextInt();
        System.out.println("请输入用户体重（kg）：");
        user.weight = sc.nextDouble();
        System.out.println("请输入用户身高（m）：");
        user.height = sc.nextDouble();
    }

    public static void printUserInfo(User user){
        System.out.println("用户 " + user.name + " 的 BMI 为：" + user.BMI);
        System.out.println("BMR 为：" + user.BMR);
    }

    public static void getBMI(User user){
        user.BMI = user.weight / (user.height * user.height);
    }

    public static void getBMR(User user){
        if (user.gender) {
            user.BMR = 10 * user.weight + 6.25 * user.height * 100 - 5 * user.age + 5;
        } else {
            user.BMR = 10 * user.weight + 6.25 * user.height * 100 - 5 * user.age - 161;
        }
    }
}
