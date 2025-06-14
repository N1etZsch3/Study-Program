package com.n1etzsch3.abstractdemo2;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.setName("咪咪");
        dog.setName("大黄");

        cat.cry();
        dog.cry();

        System.out.println(cat);
        System.out.println(dog);
    }
}
