package com.n1etzsch3.enumdemo;

public enum Season {  // 使用enum关键字声明这是一个枚举类
    // ▼ 1. 枚举常量声明（核心部分）▼
    SPRING("春天", "温暖"),   // 创建SPRING实例，传入参数
    SUMMER("夏天", "炎热"),   // 创建SUMMER实例，传入参数
    AUTUMN("秋天", "凉爽"),   // 创建AUTUMN实例，传入参数
    WINTER("冬天", "寒冷");   // 创建WINTER实例，传入参数 [注意结尾用分号!]

    // ▼ 2. 成员变量（封装数据）▼
    private final String name;  // 季节名称（final确保不可变）
    private final String desc;   // 季节描述（final确保不可变）

    // ▼ 3. 构造方法（关键连接点）▼
    Season(String name, String desc) {  // 参数与枚举常量传入值匹配
        this.name = name;  // SPRING("春天",..) → 此处 this.name = "春天"
        this.desc = desc;  // SPRING("春天",..) → 此处 this.desc = "温暖"
    }

    // ▼ 4. 访问方法（获取数据）▼
    public String getName() { return name; }   // 获取季节名
    public String getDesc() { return desc; }   // 获取季节描述

    // ▼ 5. 重写toString方法（自定义输出）▼
    @Override
    public String toString() {
        return name + "：" + desc;  // 示例：SPRING → "春天：温暖"
    }
}
