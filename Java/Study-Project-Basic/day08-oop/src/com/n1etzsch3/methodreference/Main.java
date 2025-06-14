package com.n1etzsch3.methodreference;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 完成给数组排序，使用匿名内部类
        // 创建一个学生类型的数组，存放六个学生对象
        Student[] students = new Student[6];
        students[0] = new Student("张三", 20, "男", 1.75);
        students[1] = new Student("李四", 22, "女", 1.65);
        students[2] = new Student("王五", 21, "男", 1.80);
        students[3] = new Student("赵六", 19, "女", 1.70);
        students[4] = new Student("钱七", 23, "男", 1.78);
        students[5] = new Student("孙八", 20, "女", 1.60);

        // 按照年龄升序排序
        // sortStudentsByAge(students);

        // 按照身高升序排序
        sortStudentsByHeight(students);

        // 显示所有学生信息
        showAllStudents(students);

    }

    public static void showAllStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void sortStudentsByAge(Student[] students){
        // 按年龄升序排序，通过调用API对数组排序：
        // public static void sort(Object[] a, Comparator<? super Object> c)
        Arrays.sort(students, Student::compareByAge);
    }

    public static void sortStudentsByHeight(Student[] students){
        Student s = new Student();
        Arrays.sort(students, s::compareByHeight);
    }

}
