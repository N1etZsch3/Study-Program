package com.n1etzsch3.methodreference;

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

    public static int compareByAge(Student s1, Student s2) {
        return s1.getAge() - s2.getAge();
    }

    public int compareByHeight(Student s1, Student s2) {
        return Double.compare(s1.getHeight(), s2.getHeight());
    }

}
