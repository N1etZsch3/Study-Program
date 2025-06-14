package com.n1etzsch3.innerclass2;

public class Test {
    public static void main(String[] args) {
        // 使用匿名内部类参数实现Skill接口
        swim(new Skill() {;
            @Override
            public void swimming() {
                System.out.println("Student Swimming skill implemented.");
            }
        });

        swim(new Skill() {
            @Override
            public void swimming() {
                System.out.println("Teacher Swimming skill implemented.");
            }
        });
    }

    public static void swim(Skill skill) {
        skill.swimming();
    }
}

interface Skill {
    void swimming();
}