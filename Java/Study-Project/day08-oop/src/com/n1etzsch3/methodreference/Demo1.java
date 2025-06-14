package com.n1etzsch3.methodreference;

import java.util.Arrays;
import java.util.Comparator;

public class Demo1 {
    public static void main(String[] args) {

        String[] names = {"Tom", "jeery", "Alice", "Charlie", "andy", "Eva", "frank", "张三", "Lily", "Bob"};

        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));

    }
}
