package com.n1etzsch3.interface1;

// 使用interface关键字定义。
public interface A {
    // JDK8之前，接口中只能定义常量和抽象方法。修饰符必须是public。

    // 1、常量：在接口中，常量的static final可以省略不写。下述二者等效。
    String NAME1 = "张三";
    public static final String NAME2 = "李四";

    // 2、抽象方法：在接口中，抽象方法的abstract可以省略不写。下述二者等效。
    public abstract void play();
    void show();
}
