package com.n1etzsch3.polymorphism;

public class Tortoise extends Animal {
    String name = "Tortoise";

    @Override
    public void run(){
        System.out.println("Tortoises run slowly!");
    }

    public void pullIntoShell(){
        System.out.println("Tortoises pull themselves into shell!");
    }

}
