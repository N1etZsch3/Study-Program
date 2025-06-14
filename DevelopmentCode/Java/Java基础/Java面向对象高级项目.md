# 班级学生信息管理模块

## 需求

+ 学生的数据有：姓名、性别、成绩。
+ 功能1: 要求打印出全班学生的信息；
+ 功能2: 要求打印全班同学的平均成绩。

## 要求

以上功能有多套实现方案，比如：

+ 第1套方案：能打印出全部学生的信息；能打印全部学生的平均分。
+ 第2套方案：能打印出全部学生的信息（包括男女人数）；能打印班级全部学生的平均分（去掉最高分，最低分）。

系统可以支持灵活的切换这些方案。

## 实现

### 结构

```java
demo1
├── Main.java 	// 程序入口
├── Scheme.java	// 方案接口
├── Scheme1.java	// 方案1实现类
├── Scheme2.java	// 方案2实现类
└── Student.java	// 学生类

```



### `Student.java`

```java
package com.n1etzsch3.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String gender;
    private double grade;
}

```



### `Scheme.java`

```java
package com.n1etzsch3.demo1;

public interface Scheme{

    public void showAllStudentsInfo(Student[] students);

    public void showAverageScore(Student[] students);

}

```



### `Scheme1.java`

```java
package com.n1etzsch3.demo1;

public class Scheme1 implements Scheme{

    @Override
    public void showAllStudentsInfo(Student[] students) {
        for (Student s : students){
            System.out.printf("姓名：%s\t性别：%s\t成绩：%.2f", s.getName(), s.getGender(), s.getGrade());
            System.out.println();
        }
    }

    @Override
    public void showAverageScore(Student[] students) {
        double averageScore = 0;
        for (Student s : students){
            averageScore += s.getGrade();
        }
        System.out.printf("全班的平均分是：%.2f", averageScore/students.length);
    }
}

```



### `Scheme2.java`

```java
package com.n1etzsch3.demo1;

public class Scheme2 implements Scheme{

    @Override
    public void showAllStudentsInfo(Student[] students) {
        int maleNumbers=0;
        int femaleNumbers=0;
        for (Student s : students){
            if(s.getGender().equals("男")){
                maleNumbers++;
            }
            else {
                femaleNumbers++;
            }
            System.out.printf("姓名：%s\t性别：%s\t成绩：%.2f", s.getName(), s.getGender(), s.getGrade());
            System.out.println();
        }

        System.out.printf("男生共有%d人\t女生共有%d人",maleNumbers, femaleNumbers);
        System.out.println();
    }

    @Override
    public void showAverageScore(Student[] students) {
        double averageScore = 0;
        double max = students[0].getGrade();
        double min = students[0].getGrade();
        for (Student s : students){
            if(s.getGrade() > max){
                max = s.getGrade();
            }
            if(s.getGrade() < min){
                min = s.getGrade();
            }
            averageScore += s.getGrade();
        }
        averageScore -= max + min;
        System.out.printf("去掉一个最高分%.2f，去掉一个最低分%.2f\n", max, min);
        System.out.printf("全班的平均分是：%.2f", averageScore/(students.length-2));
    }
}

```



### `Main.java`

```java
package com.n1etzsch3.demo1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 生成五个学生对象
        Student[] students = new Student[5];
        students[0] = new Student("张三", "男", 85.5);
        students[1] = new Student("李四", "女", 90.0);
        students[2] = new Student("王五", "男", 78.0);
        students[3] = new Student("赵六", "女", 88.5);
        students[4] = new Student("钱七", "男", 92.0);

        Scheme sc = getSchene();
        if (sc != null) {
            sc.showAllStudentsInfo(students);
            sc.showAverageScore(students);
        }
        else System.out.println("输入有误！");
    }

    public static Scheme getSchene(){
        System.out.println("请选择实现方案：(1、基础\\2、高级)");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        return switch (option) {
            case 1 -> new Scheme1();
            case 2 -> new Scheme2();
            default -> null;
        };
    }
}

```

