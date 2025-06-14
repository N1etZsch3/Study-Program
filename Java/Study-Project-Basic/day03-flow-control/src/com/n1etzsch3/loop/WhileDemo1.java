package com.n1etzsch3.loop;

public class WhileDemo1 {
    public static void main(String[] args) {
        double principle = 100000;
        double rate = 0.017;
        System.out.println("You may spend " + calc(principle, rate) + " years.");
    }

    public static int calc(double principle, double rate){
        int years = 0;
        double target = principle * 2;
        while(principle < target){
            principle *= 1+rate;
            years++;
        }
        return years;
    }

}
