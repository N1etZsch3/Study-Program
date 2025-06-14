package com.n1etzsch3.lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        // 使用Lambda表达式代替匿名内部类对象
        String name = "🧑‍🎓";
        Skill s = n -> n+"Student can swim!";
        System.out.println(s.swimming(name));
    }
}

@FunctionalInterface
interface Skill{
    String swimming(String name);
}

