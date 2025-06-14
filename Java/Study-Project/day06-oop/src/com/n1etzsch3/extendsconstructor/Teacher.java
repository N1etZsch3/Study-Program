package com.n1etzsch3.extendsconstructor;

public class Teacher extends People {
    private String skills;
    private String school;

    public Teacher(){}

    public Teacher(String name, int age, String gender) {
        this(name, age, gender, "Java", "QingHua University");
    }

    public Teacher(String name, int age, String gender, String skills, String school) {
        super(name, age, gender);
        setSkills(skills);
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
