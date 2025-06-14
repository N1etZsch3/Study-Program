package com.n1etzsch3.object;

public class Star {
    String name;
    String gender;
    int age;
    double height;
    double weight;

    public void printStarsInfo(){
        System.out.println("The star "+ name +"'s age is " + age +", and she is a " + gender + ", whose weight is "+ weight +" and height is " + height + " .");
    }

}
