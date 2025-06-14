package com.n1etzsch3.stringdemo2;

import java.util.Scanner;

public class VerificationCode {
    public static void main(String[] args) {
        // 生成一个6位的验证码，并要求用户输入该验证码进行验证
        String code = generateCode(6);
        System.out.println("Generated Verification Code: " + code);
        Scanner sc = new Scanner(System.in);

        // 循环验证用户输入的验证码是否正确
        boolean flag = true;
        while (flag){
            System.out.print("Please enter the verification code (Case Sensitive) : ");
            String input = sc.nextLine();
            if (verifyCode(code, input)) {
                System.out.println("Verification successful!");
                flag = false;
            } else {
                System.out.println("Verification failed. Please try again.");
            }
        }

        System.out.println("Welcome to the system!");
    }

    // 随机生成器
    public static String generateCode(int length) {
        // 使用StringBuilder保存生成的验证码
        StringBuilder code = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            code.append(characters.charAt(index));  // 调用append方法将字符添加到StringBuilder中
        }
        return code.toString();
    }

    /**
     * 验证用户输入的验证码是否正确
     * @param code 生成的验证码
     * @param input 用户输入的验证码
     * @return 如果验证码匹配返回true，否则返回false
     */
    public static boolean verifyCode(String code, String input) {
        return code.equals(input);
    }

}
