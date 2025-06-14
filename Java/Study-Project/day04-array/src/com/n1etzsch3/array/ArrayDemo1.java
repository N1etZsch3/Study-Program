package com.n1etzsch3.array;

public class ArrayDemo1 {
    public static void main(String[] args) {
        randomName();
    }

    // 需求：开发一个随机点名的方法，假设有15名学生
    public static void randomName(){
        String[] names = {"张三", "李四", "王五", "赵六", "钱七", "孙八", "周九", "吴十", "郑十一", "冯十二", "陈十三", "褚十四", "卫十五", "蒋十六", "沈十七"};
        // 1.创建一个随机数对象
        int index = (int)(Math.random()*names.length);
        String name = names[index];
        System.out.println(name);
    }

}
