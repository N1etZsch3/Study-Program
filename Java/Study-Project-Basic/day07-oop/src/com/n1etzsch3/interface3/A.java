package com.n1etzsch3.interface3;

public interface A {
    default void go(){
        System.out.println("Let's go!!!");
        run();
    }

    private void run(){
        System.out.println("Running is fast going!");
    }

    static void show(){
        System.out.println("Showing means to print information!");
    }

}
