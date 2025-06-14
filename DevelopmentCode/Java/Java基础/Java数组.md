# Java数组



## 一、一维数组

### **示例代码：**

```java
package com.n1etzsch3.array;

public class ArrayDemo1 {
    public static void main(String[] args) {
        randomName();
    }

    // 需求：开发一个随机点名的方法，假设有15名学生
    public static void randomName(){
        String[] names = {"张三", "李四", "王五", "赵六", "钱七", "孙八", "周九", "吴十", "郑十一", "冯十二", "陈十三", "褚十四", "卫十五", "蒋十六", "沈十七"};
        // 1.创建一个随机数对象
        int index = (int)(Math.random()*names.length);
        String name = names[index];
        System.out.println(name);
    }

}

```

> 解释：`int index = (int)(Math.random()*names.length);`语句中，Math.randon()函数用于获取0-1之间的任意小数，开区间。再乘以数组的长度，再取整，就可以取得数组大小范围的下标而不会溢出。

### 定义数组

#### 声明数组	

​	数组的声明既可以是**`数据类型[] 数组名;`**又可以是**`数据类型 数组名[];`**。例如：

```java
int[] intArray;
int intArry[];
```

#### 初始化数组

##### 静态初始化数组

​	直接硬编码定义，例如：

```java
int[] num = {1,2,3,4,5};
```

**动态初始化数组**

​	**`数据类型[] 数组名 = new 数据类型[长度];`**，不预先存储数据。例如：

```java
int[] num = new int[5];
```

> int数组的默认值是0，double数组的默认值是0.0，boolean数组的默认值是false。



### 一维数组综合案例

#### 1、处理成绩

```java
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
```

#### 2、扑克牌游戏

​	对一副54张牌的扑克进行做牌（按顺序排列），洗牌（打乱）。

```java
package com.n1etzsch3.array;

public class Demo2 {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        String[] poker = new String[54];
        stack(poker);
        System.out.println("\nShuffling----------------------------------------------------------");
        shuffle(poker);
    }

    public static void stack(String[] poker){
        int n = 0;
        char[] suit = {'♠', '♥','♦','♣'};
        String[] cardFace = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        // 假如相同花色的放一起：
        for(int i = 0; i < suit.length; i++){
            for(int j = 0; j < cardFace.length; j++){
                 poker[n++] = suit[i] + cardFace[j];
            }
        }

        poker[52] = "小王";
        poker[53] = "大王";

        // 输出牌面，每13个一组，大小王单独输出
        for(int i = 0; i < poker.length; i++){
            if(i % 13 == 0){
                System.out.println();
            }
            System.out.print(poker[i] + "\t");
        }
        System.out.println();
    }

    public static void shuffle(String[] poker){
        for(int i = poker.length - 1; i > 0; i--){
            int j = (int)(Math.random() * (i + 1));
            // 交换 poker[i] 和 poker[j]
            String temp = poker[i];
            poker[i] = poker[j];
            poker[j] = temp;
        }

        // 输出洗牌后的结果，每13个一行
        for(int i = 0; i < poker.length; i++){
            if(i % 13 == 0) System.out.println();
            System.out.print(poker[i] + "\t");
        }
        System.out.println();
    }

}

```

## 二、二维数组

​	**二维数组的声明和定义和C语言类似。**

### 二维数组案例

#### 1、石板迷阵初始化

```java
package com.n1etzsch3.array;

// 石头迷阵游戏初始化

import java.util.Random;

public class ArrayDemo2 {
    // 程序入口
    public static void main(String[] args) {
        start();
    }
    // 游戏开始
    public static void start(){
        int order = 4;
        int[][] map = new int[order][order];
        init(map, order);
        System.out.println("----------------------------------------");
        shuffle(map);
    }

    // 初始化石板迷阵
    public static void init(int[][] map, int order){
        // 创建一个二维数组记录石板数字

        int count = 1;

        for(int i = 0; i< map.length; i++){
            for (int j = 0; j<map[i].length; j++){
                map[i][j] = count++;
            }
        }
        map[order-1][order-1] = 0;
        printMap(map);
    }



    public static void shuffle(int[][] map){
      // 思路是将二维数组看成连续的一位数组，然后将一维数组的索引转化为二维数组的坐标。
        int rows = map.length;
        if (rows == 0) return;
        int cols = map[0].length;
        int total = rows * cols;
        Random rand = new Random();

        for(int i = total - 1; i > 1; i--){

          // 方法rand.nextInt(int bound)用于生成一个0-bound范围的伪随机数。生成一个随机索引。
            int j = rand.nextInt(i+1);

          // 通过一维索引转换二维坐标。
            int rowI = i / cols, colI = i % cols;
            int rowJ = j / cols, colJ = j % cols;

            int temp = map[rowI][colI];
            map[rowI][colI] = map[rowJ][colJ];
            map[rowJ][colJ] = temp;

        }

        printMap(map);

    }


    public static void printMap(int[][] map){
        for(int i = 0; i< map.length; i++){
            for(int j = 0; j< map[i].length; j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

```

