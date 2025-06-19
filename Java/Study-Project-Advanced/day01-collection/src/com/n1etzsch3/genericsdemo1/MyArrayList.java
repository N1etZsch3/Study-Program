package com.n1etzsch3.genericsdemo1;

import java.util.ArrayList;

// 自定义泛型类 MyArrayList
// 用装饰器模式实现一个简单的 ArrayList 功能
public class MyArrayList <E> {

    ArrayList<E> list = new ArrayList<>();

    public void add(E element) {
        list.add(element);
    }

    public void remove(E element) {
        list.remove(element);
    }

    public void modify(int index, E element) {
        if (index >= 0 && index < list.size()) {
            list.set(index, element);
        } else {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
        }
    }

    public void query(E element) {
        if (list.contains(element)) {
            System.out.println("Element found: " + element);
        } else {
            System.out.println("Element not found: " + element);
        }
    }

    public void printList() {
        System.out.println("List contents: " + list.toString());
    }
}
