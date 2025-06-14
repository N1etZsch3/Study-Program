package com.n1etzsch3.extendsoverride;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.sayHello();
    }
}

class Father{
    public void sayHello(){
        System.out.println("I am father");
    }
}

class Son extends Father{
    @Override   // 方法重写的校验注解（标志），要求方法名称、形参列表必须与被重写方法一致。
    public void sayHello(){
        System.out.println("I am son");
    }
}

