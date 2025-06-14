package com.n1etzsch3.loop;

public class DoWhileDemo1 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        // 需求：打印1-100之间的所有偶数
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 100);
    }
}
