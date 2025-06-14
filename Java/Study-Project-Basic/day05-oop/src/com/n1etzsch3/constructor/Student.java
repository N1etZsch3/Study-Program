package com.n1etzsch3.constructor;

public class Student {
    String name;
    int age;
    String gender;

    public Student (){}

    public Student(String n, int a, String g){
        name = n;
        age = a;
        gender = g;
    }

    public void printStudentsInfo(){
        System.out.println(name + "'s age is " + age + ", and his gender is " + gender + ".");
    }

}
