package com.n1etzsch3.capsulation;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Zhang San", 18, "Male", 112.1, 99.9, 100.0);
        StudentOperator s1o = new StudentOperator(s1);
        s1o.printInfo();
        s1o.printAverage();
        s1o.printTotal();
    }
}
