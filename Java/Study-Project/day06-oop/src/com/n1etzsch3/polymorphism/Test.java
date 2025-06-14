package com.n1etzsch3.polymorphism;

public class Test {
    public static void main(String[] args) {
        Animal a1 = new Tortoise();
        Animal a2 = new Wolf();

        go(a1);
        go(a2);
    }

    public static void go(Animal animal) {
        System.out.println("Start running!");
        animal.run();
    }
}
