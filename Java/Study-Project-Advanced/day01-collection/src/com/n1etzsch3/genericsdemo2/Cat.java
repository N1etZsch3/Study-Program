package com.n1etzsch3.genericsdemo2;

public class Cat implements AnimalOperator<Cat> {

    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void add(Cat animal) {
        System.out.println("Adding cat: " + animal.getName());
    }

    @Override
    public void remove(Cat animal) {
        System.out.println("Removing cat: " + animal.getName());
    }

    @Override
    public void modify(int index, Cat animal) {
        System.out.println("Modifying cat at index " + index + " to: " + animal.getName());
    }

    @Override
    public void query(Cat animal) {
        System.out.println("Querying cat: " + animal.getName());
    }

    @Override
    public void printList() {
        System.out.println("Printing cat list...");
    }
}
