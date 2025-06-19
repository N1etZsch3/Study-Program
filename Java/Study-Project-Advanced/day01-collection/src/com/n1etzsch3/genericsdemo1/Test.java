package com.n1etzsch3.genericsdemo1;

public class Test {

    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>();
        // 添加元素
        myList.add("Hello");
        myList.add("World");
        myList.add("Generics");

        // 打印列表内容
        myList.printList();

        // 查询元素
        myList.query("World");

        // 修改元素
        myList.modify(1, "Java");
        myList.printList();

        // 删除元素
        myList.remove("Hello");
        myList.printList();

        MyArrayList<Integer> intList = new MyArrayList<>();

        // 添加整数元素
        intList.add(1);
        intList.add(2);
        intList.add(3);

        // 打印整数列表内容
        intList.printList();

        // 查询整数元素
        intList.query(2);

        // 修改整数元素
        intList.modify(1, 20);
        intList.printList();

        // 删除整数元素
        intList.remove(1);
        intList.printList();
    }

}
