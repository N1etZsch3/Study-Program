package com.n1etzsch3.genericsdemo2;

public class Dog implements AnimalOperator<Dog>{

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void add(Dog animal) {
        System.out.println("Adding dog: " + animal.getName());
    }

    @Override
    public void remove(Dog animal) {
        System.out.println("Removing dog: " + animal.getName());
    }

    @Override
    public void modify(int index, Dog animal) {
        System.out.println("Modifying dog at index " + index + " to: " + animal.getName());
    }

    @Override
    public void query(Dog animal) {
        System.out.println("Querying dog: " + animal.getName());
    }

    @Override
    public void printList() {
        System.out.println("Printing dog list...");
    }
}
