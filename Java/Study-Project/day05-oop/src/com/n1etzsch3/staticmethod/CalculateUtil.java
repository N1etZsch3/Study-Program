package com.n1etzsch3.staticmethod;

public class CalculateUtil {

    // 工具类没有创建对象的必要性，建议构造器私有。即无法创建对象。
    private CalculateUtil(){};

    // 累加
    public static int accumulation(int ... numbers){
        int total = 0;
        for(int num : numbers){
            total += num;
        }
        return total;
    }

    // 累乘
    public static long multiplicative(int n){
        long product = 1;
        for(int i = 1; i <= n; i++){
            product *= i;
        }
        return product;
    }

    // 累乘和
    public static long muAcc(int n){
        long product = 1;
        long result = 0;
        for(int i = 1; i <= n; i++){
            product *= i;
            result += product;
        }
        return result;
    }

}
