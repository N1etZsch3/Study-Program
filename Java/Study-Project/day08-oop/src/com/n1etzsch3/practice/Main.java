package com.n1etzsch3.practice;

public class Main {
    public static void main(String[] args) {
        GeometryOperator circle = (pi, r) -> pi * r * r;
        GeometryOperator triangle = (bottom, height) -> bottom * height / 2;
        GeometryOperator rectangle = (weight, height) -> height * weight;

        circle.showArea("circle", circle.calculateArea(3.14, 5));
        triangle.showArea("triangle", triangle.calculateArea(10, 5));
        rectangle.showArea("rectangle", rectangle.calculateArea(10, 5));
    }
}
