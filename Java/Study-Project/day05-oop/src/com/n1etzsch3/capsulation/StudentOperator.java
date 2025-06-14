package com.n1etzsch3.capsulation;

public class StudentOperator {
    private Student s;

    public StudentOperator(){}

    public StudentOperator(Student s){
        this.s = s;
    }

    public Student getS() {
        return s;
    }

    public void printInfo(){
        System.out.println( s.getName() + " " + s.getAge() + " " + s.getGender());
    }

    public double getAverageGrade(){
        return (s.getChineseGrade() + s.getMathGrade() + s.getEnglishGrade()) / 3;
    }

    public void printAverage(){
        System.out.println(s.getName() + " " + getAverageGrade());
    }

    public double getTotalGrade(){
        return s.getChineseGrade() + s.getMathGrade() + s.getEnglishGrade();
    }

    public void printTotal(){
        System.out.println(s.getName() + " " + getTotalGrade());
    }
}
