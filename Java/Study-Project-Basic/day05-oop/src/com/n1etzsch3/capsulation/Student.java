package com.n1etzsch3.capsulation;

public class Student {
    private String name;
    private int age;
    private String gender;
    private double chineseGrade;
    private double englishGrade;
    private double mathGrade;

    public Student(){};

    public Student(String name, int age, String gender,double chineseGrade, double englishGrade, double mathGrade){
        setName(name);
        setAge(age);
        setGender(gender);
        setChineseGrade(chineseGrade);
        setEnglishGrade(englishGrade);
        setMathGrade(mathGrade);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
         this.gender = gender;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }


    public double getChineseGrade() {
        return chineseGrade;
    }

    public void setChineseGrade(double chineseGrade) {
        this.chineseGrade = chineseGrade;
    }

    public double getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(double englishGrade) {
        this.englishGrade = englishGrade;
    }

    public double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(double mathGrade) {
        this.mathGrade = mathGrade;
    }

}
