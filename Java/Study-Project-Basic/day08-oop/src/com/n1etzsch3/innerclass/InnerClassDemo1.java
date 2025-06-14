package com.n1etzsch3.innerclass;

public class InnerClassDemo1 {
    public static void main(String[] args) {
        // 创建静态内部类的实例语法
        // Outer.Inner inner = new Outer.Inner();
        Outer.Inner inner = new Outer.Inner();
        // 调用静态内部类的方法
        inner.display();
    }
}
