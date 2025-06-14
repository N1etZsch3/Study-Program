package com.n1etzsch3.extendsdemo;

public class Test {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setName("N1etZsch3");
        t1.setAge(20);
        t1.setGender("Male");
        t1.setSkills("Java, Python, C++");

        System.out.println(t1.getName()
                + "is a "
                + t1.getAge()
                + " years old boy, and he can use "
                + t1.getSkills()
                + ".");

        Consultant c1 = new Consultant();
        c1.setName("Zhang San");
        c1.setAge(20);
        c1.setGender("Female");
        c1.setUsersCount(20);

        System.out.println(c1.getName()
                + " is a "
                + c1.getAge()
                + " years old girl, and she has "
                + c1.getUsersCount()
                + " clients.");
    }
}
