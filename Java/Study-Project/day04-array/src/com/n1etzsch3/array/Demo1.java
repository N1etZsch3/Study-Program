package com.n1etzsch3.array;

import javax.swing.*;
import java.util.Scanner;

public class Demo1 {
    //  需求：录入五名学生的成绩，求最大值，最小值，平均值，总和，排序后输出。
    public static void main(String[] args) {
        double[] grades = new double[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入学生成绩：");
        for (int i = 0; i< grades.length; i++){
            grades[i] = scanner.nextDouble();
        }
        double max = getMax(grades);
        double min = getMin(grades);
        double sum = getSum(grades);
        double average = getAverage(grades);
        System.out.println("最大值为：" + max);
        System.out.println("最小值为：" + min);
        System.out.println("总和为：" + sum);
        System.out.println("平均值为：" + average);
        System.out.println("排序后成绩为：");
        sort(grades);
    }

    // 获取最大值
    public static double getMax(double[] grades){
        double max = grades[0];
        for (int i = 1; i < grades.length; i++){
            if (grades[i] > max) max = grades[i];
        }
        return max;
    }

    // 获取最小值
    public static double getMin(double[] grades){
        double min = grades[0];
        for(int i = 1; i< grades.length; i++){
            if(grades[i] < min) min = grades[i];
        }
        return min;
    }

    // 总和
    public static double getSum(double[] grades){
        double sum = 0;
        for(int i = 0; i< grades.length; i++){
            sum += grades[i];
        }
        return sum;
    }

    // 平均值
    public static double getAverage(double[] grades){
        return getSum(grades) / grades.length;
    }

    // 排序输出
    public static void sort(double[] grades){
        for(int i = 0; i < grades.length - 1; i++){
            for(int j = 0; j < grades.length-i-1; j++){
                if(grades[j] > grades[j+1]){
                    double t = grades[j];
                    grades[j] = grades[j+1];
                    grades[j+1] = t;
                }
            }
        }
        for(int i = 0; i < grades.length; i++){
            System.out.println(grades[i]);
        }
    }

}
