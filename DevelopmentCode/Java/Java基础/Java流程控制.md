# Java流程控制



## 一、分支结构

### if语句

```java
package com.n1etzsch3.branch;

import java.util.Scanner;

public class IfDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an your age: ");
        int age = sc.nextInt();
        test1(age);
    }
    
    public static void test1(int age){
        if (age >= 18){
            System.out.println("You can surf the internet");
        }
        else System.out.println("You can not surf the internet");
    }
    
}

```



### switch语句

```java
package com.n1etzsch3.branch;

import java.util.Scanner;

public class SwitchDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入分数：");
        int grade = scanner.nextInt();
        test1(grade);
    }

    public static void test1(int grade){
        // 根据分数输出等级
        switch(grade){
            case 90:
                System.out.println("A");
                break;
            case 80:
                System.out.println("B");
                break;
            case 70:
                System.out.println("C");
                break;
            case 60:
                System.out.println("D");
                break;
            default:
                System.out.println("E");
        }
    }
}

```

**`switch`语句的性能要优于`if`语句**

两种分支语句的语法和格式都和C语言类似。



## 二、循环结构

### for循环

​	和C语言语法类似

```java
package com.n1etzsch3.loop;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number = scanner.nextInt();
        isPrime(number);
    }

    public static void isPrime(int n){
        int i;
        for(i = 2; i*i <= n; i++){
            if(n % i == 0) break;
        }
        if(i * i > n){
            System.out.println(n + " is prime number");
            return;
        }
        System.out.println(n + " is not prime number");
    }
}
```



### while循环

```java
// 有100000的本金，利率为1.7%，问多少年后，本金翻倍。
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
```



### do-while循环

```java
package com.n1etzsch3.loop;

public class DoWhileDemo1 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        // 需求：打印1-100之间的所有偶数
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 100);
    }
}

```





