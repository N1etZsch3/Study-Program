package com.n1etzsch3.arraylist;

import java.util.ArrayList;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();  // 泛型定义集合

        // 1、添加元素
        list.add("Hello");
        list.add("Java2");
        list.add("Java");  // 使用add方法添加元素
        // 2、删除元素
        list.remove("Hello");  // 使用remove方法删除元素
        list.remove(1);  // 使用remove方法删除指定索引位置的元素
        // 3、修改元素
        list.set(0, "World");  // 使用set方法修改指定索引位置的元素
        // 4、查看元素
        String element = list.get(0);  // 使用get方法获取指定索引位置的元素
        System.out.println("第一个元素是: " + element);  // 输出第一个元素
        // 5、查看集合大小
        int size = list.size();  // 使用size方法获取集合的大小
        System.out.println("集合的大小是: " + size);  // 输出集合的大小
        // 6、遍历集合
        for (String str : list) {  // 使用增强for循环遍历集合
            System.out.println("集合中的元素: " + str);  // 输出每个元素
        }
    }
}
