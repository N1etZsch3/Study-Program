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
