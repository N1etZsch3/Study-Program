package com.n1etzsch3.extendsfeature;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}

class Father{
    String name = "Father";
}

class Son extends Father{
    String name = "Son";

    public void show(){
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
