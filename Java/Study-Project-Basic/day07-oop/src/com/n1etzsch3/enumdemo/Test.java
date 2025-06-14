package com.n1etzsch3.enumdemo;

public class Test {
    public static void main(String[] args) {
        // 获取枚举实例
        Season current = Season.SUMMER;

        // 访问数据
        System.out.println(current.getName());  // 输出：夏天
        System.out.println(current.getDesc());  // 输出：炎热

        // 自动调用toString()
        System.out.println(current);  // 输出：夏天：炎热

        // 获取所有枚举值
        for (Season s : Season.values()) {
            System.out.println(s.name() + " - " + s.getDesc());
        }
    }
}
