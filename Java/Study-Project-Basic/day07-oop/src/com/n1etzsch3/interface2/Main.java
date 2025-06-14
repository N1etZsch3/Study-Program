package com.n1etzsch3.interface2;

public class Main {
    public static void main(String[] args) {
        people p = new Student();
        Driver d = new Student();
        Cooker c = new Student();
        Teacher t = new Student();

    }
}

interface Driver{}

interface Cooker{}

interface Teacher{}

class people{}

class Student extends people implements Driver, Cooker, Teacher{}
