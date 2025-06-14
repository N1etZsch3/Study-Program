package com.n1etzsch3.singletondemo;

public class Singleton {
    // 2、定义一个静态变量用于记录本类的唯一对象。
    private static Singleton instance;

    // 1、私有化构造器，限制创造对象。
    private Singleton() {}

    // 3、提供一个公共方法，用于构建对象。
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
