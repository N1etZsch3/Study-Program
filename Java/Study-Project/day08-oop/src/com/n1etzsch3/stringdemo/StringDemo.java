package com.n1etzsch3.stringdemo;

public class StringDemo {
    public static void main(String[] args) {
        // 字符串常用方法
        String str = "Hello, World!";
        System.out.println("Original String: " + str);
        System.out.println("Length: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Substring (7, 12): " + str.substring(7, 12));
        System.out.println("Index of 'World': " + str.indexOf("World"));
        System.out.println("Replace 'World' with 'Java': " + str.replace("World", "Java"));
        System.out.println("Starts with 'Hello': " + str.startsWith("Hello"));
        System.out.println("Ends with '!': " + str.endsWith("!"));
        System.out.println("Contains 'Hello': " + str.contains("Hello"));
        System.out.println("Trimmed String: '" + "   Hello, World!   ".trim() + "'");
        System.out.println("Split by ', ': ");
        String[] parts = str.split(", ");
        for (String part : parts) {
            System.out.println(part);
        }
        System.out.println("Character at index 4: " + str.charAt(4));
        System.out.println("String equals 'Hello, World!': " + str.equals("Hello, World!"));
        System.out.println("String equalsIgnoreCase 'hello, world!': " + str.equalsIgnoreCase("hello, world!"));
        System.out.println("String hashCode: " + str.hashCode());
        System.out.println("String isEmpty: " + str.isEmpty());
        System.out.println("String valueOf(123): " + String.valueOf(123));
        System.out.println("String format: " + String.format("Hello, %s!", "Java"));
        System.out.println("String join: " + String.join(", ", "Hello", "World", "Java"));
    }
}
