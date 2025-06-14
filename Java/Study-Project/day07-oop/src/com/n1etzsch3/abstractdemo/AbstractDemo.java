package com.n1etzsch3.abstractdemo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractDemo {
    private int num;
    private String name;

    // 抽象方法：没有方法体，子类必须实现
    public abstract void a();  // 子类必须实现此方法

    public abstract void b();

    public abstract void c();

    public void display() {
        System.out.println("Display method in AbstractDemo.");
    }

}
