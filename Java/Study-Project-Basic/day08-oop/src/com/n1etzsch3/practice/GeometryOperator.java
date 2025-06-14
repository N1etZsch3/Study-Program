package com.n1etzsch3.practice;

public interface GeometryOperator {
    double calculateArea(double a1, double a2);

    default void showArea(String name, double area){
        System.out.println("Shape " + name + "'s " + "area is " + area + " square centimetre.");
    }
}
