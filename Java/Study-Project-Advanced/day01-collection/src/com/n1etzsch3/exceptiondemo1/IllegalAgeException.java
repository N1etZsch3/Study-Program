package com.n1etzsch3.exceptiondemo1;

/**
 * 自定义编译时异常：
 * 1、继承Exception。
 * 2、重写构造器。
 */

public class IllegalAgeException extends Exception {
    public IllegalAgeException(){
    }
    public IllegalAgeException(String message){
        super(message);
    }
}
