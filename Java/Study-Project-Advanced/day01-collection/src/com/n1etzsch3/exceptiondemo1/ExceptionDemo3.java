package com.n1etzsch3.exceptiondemo1;

public class ExceptionDemo3 {
    public static void main(String[] args) {
        try {
            checkAge(1100);
            System.out.println("年龄合法");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("年龄不合法");
        }
    }

    // 需求：如果年龄不满18岁，抛出未成年异常。如果年龄小于0岁，或者大于150岁，抛出年龄错误异常
    public static void checkAge(int age) throws Exception{
        if (age < 18 && age >= 0) {
            throw new IllegalAgeRuntimeException("未成年异常：年龄必须大于等于18岁");
        }

        if (age < 0 || age > 150){
            throw new IllegalAgeRuntimeException("年龄数值非法！");
        }
    }
}
