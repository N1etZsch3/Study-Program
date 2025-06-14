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
            System.out.printf("姓名：%s\t性别：%s\t成绩：%.2f", s.getName(), s.getGender(), s.getGrade());
            System.out.println();
        }
        femaleNumbers = students.length - maleNumbers;
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
