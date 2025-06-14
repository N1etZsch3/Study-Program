package com.n1etzsch3.innerclass2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    // 姓名、年龄、性别、身高
    private String name;
    private int age;
    private String gender;
    private double height;
}
