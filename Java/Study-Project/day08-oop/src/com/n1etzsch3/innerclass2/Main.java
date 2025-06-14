package com.n1etzsch3.innerclass2;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal() {
            @Override
            public void cry() {
                System.out.println("Meow");
            }
        };

        cat.cry();

    }
}
