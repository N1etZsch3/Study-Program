package com.n1etzsch3.polymorphism;

public class Wolf extends Animal {
    String name = "Wolf";

    @Override
    public void run(){
        System.out.println("Wolves run fast!");
    }

}
