# Java学习



## 一、项目结构

##### 	1、Project（工程）

##### 	2、Module（模块）

##### 	3、Package（包）

##### 	4、Class（类）

**项目举例**

```cmd
Study-Project								// Project Name
├── day01-helloworld-app		// Module Name
│   └── src						// Source Code						
│       └── com					
│           └── n1etzsch3
│               ├── hello		// Package Name (com.n1etzsch3.hello)
│               │   └── HelloWorld.java 	// Class Name
│               └── literal // Package Name (com.n1etzsch3.literal)
└── out
    └── production
        └── day01-helloworld-app
            └── com
                └── n1etzsch3
                    └── hello
                        └── HelloWorld.class

```





## 二、基础语法

### 1、基础代码样式

```java
// File name is 'HelloWorld.java'.
public class HelloWorld { // 类名需与文件名一致，首字母大写
    public static void main(String[] args) { // 程序入口
        System.out.println("Hello, World!"); // 输出语句
    }
}
```



### 2、字面量（数据类型）

​	**基础规则和C语言一致**

```java
package com.n1etzsch3.literal;

public class LiteralDemo {
    public static void main(String[] args) {
        printLiteral();
    }

    public static void printLiteral(){
        // Print a string literal
        System.out.println("Hello, World!");

        // Print an integer literal
        System.out.println(42);

        // Print a floating-point literal
        System.out.println(3.14);

        // Print a boolean literal
        System.out.println(true);

        // Print a character literal
        System.out.println('A');
    }

}
```

​	**和C语言一样，字符用单引号，字符串用双引号**



### 3、变量

​	**大部分和C语言类似**

```java
package com.n1etzsch3.variable;

public class VariableDemo1 {
    public static void main(String[] args) {
        printVariable();
    }
    public static void printVariable() {
        // Declare and initialize a variable
        int number = 42;
        String message = "Hello, World!";
        double pi = 3.14;
        boolean isJavaFun = true;
        char initial = 'N';
        
        // Print the variable
        System.out.println("Number: " + number);
        System.out.println("Message: " + message);
        System.out.println("Pi: " + pi);
        System.out.println("Is Java fun? " + isJavaFun);
        System.out.println("Initial: " + initial);
    }
}
```

​	**Java也是强类型语言**



### 4、数据类型

​	**Java将数据类型分为两大类：**

#### 	1、基本数据类型（4大类8种）

##### 		(1)、整型：byte(1字节)、short(2字节)、int(4字节)、long(8字节)

##### 		(2)、浮点型：float(4字节)、double(8字节)

##### 		(3)、字符型：char(2字节)

##### 		(4)、布尔型：boolean(1字节)

#### 	2、引用数据类型

​		

### 5、标识符

#### 	(1)、变量名：首单词首字母小写，其他单词首字母大写，小驼峰模式。

#### 	(2)、类名：首单词首字母大写，其他单词首字母大写，大驼峰模式。



### 6、方法

​	**类似于函数**

```tex
修饰符 返回值类型 方法名(形参列表){
	方法体代码(需要执行的功能代码);
	return 返回值;
}
```

​	**具体代码实例**

```java
package com.n1etzsch3.method;

public class MethodDemo1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(getSum(a, b));
        System.out.println(getMax(a, b));
    
    }
    
    public static int getSum(int a, int b){
        return a+b;
    }
    
    public static int getMax(int a, int b){
        return a > b ? a : b;
    }
    
}

```

#### 方法的重载：

​	一个类中，出现多个方法的名称相同，但是它们的形参列表是不同的，那么这些方法就称为**重载**。

```java
package com.n1etzsch3.method;

public class MethodDemo2 {
    public static void main(String[] args) {
        
    }
    public static void print(int a, int b){
        System.out.println(a);
        System.out.println(b);
    }

    public static void print(String c){
        System.out.println(c);
    }

    public static void print(String d, int a, int b){
        System.out.println(d);
        System.out.println(a);
        System.out.println(b);
    }
}

```

> 注意：方法重载的判断只关注名称是否相同，形参列表是否不同（包括类型不同，个数不同，类型顺序不同。**不包括形参名称不同。**）例如下面的方法就是**重复方法而不是重载方法**，会报错。

```java
    public static void print(int a, int b){
        System.out.println(a);
        System.out.println(b);
    }

    public static void print(int b, int a){				// 参数名称不同不算是重载方法。
        System.out.println(a);
        System.out.println(b);
    }
```

​	方法重载的意义在于：**通过方法名称标记同一功能，通过参数列表进行差异化。**例如：

```java
    // 需求：发射火箭，指定位置
    public static void fire(int x, int y){
        System.out.println("发射火箭，指定位置：" + x + "," + y);
    }
    
    //定义一个重载方法
    public static void fire(String c){
        System.out.println("发射火箭，指定位置：" + c);
    }
```

​	例如这个函数，可以传坐标值为参数，也可以直接通过地名为参数。



### 7、类型转换

##### 自动类型转换：

​	类型范围小的变量可以直接赋值给类型范围大的变量。例如`byte b`可以直接赋值给`int a`

```java
package com.n1etzsch3.type;

public class TypeDemo1 {
    public static void main(String[] args) {
        byte b = 127;
        print(b);
        print1(b);
    }

    public static void print(int a){
        System.out.println(a);
    }
    
    public static void print1(double a){
        System.out.println(a);
    }
    
}
```



##### 强制类型转换：

​	类型范围大的变量**不能**直接赋值给类型范围小的变量。语法类似于C语言。强制类型转换可能导致数据溢出，默认丢弃超出存储范围的高位数据。浮点型转换为整型，直接**丢弃**小数部分，不会四舍五入。

```java
package com.n1etzsch3.type;

public class TypeDemo2 {
    public static void main(String[] args) {
        int b = 127;
        print((byte)b);
    }
    
    public static void print(byte a){
        System.out.println(a);
    }
}
```

##### 	

##### 表达式自动类型提升：

1. 表达式的最终结果的数据类型由表达式中**类型范围最大的数据类型决定**。
2. 在表达式中，**byte**，**short**，**char**是**直接转换为int类型**参与计算的。

```java
	public static int getSum(byte a, byte b){		// 这里的返回值必须是int
  		return a + b;
  }
```



### 8、输入输出

#### 输入

​	通过Java提供的**Scanner**程序实现。

1. 首先导入对应的包文件：`import java.util.Scanner;`。
2. 然后创建一个`Scanner`对象：`Scanner sc = new Scanner(System.in);`。
3. 然后用一个参数接收输入：`String userName = sc.next();`。

```java
package com.n1etzsch3.scanner;

import java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {
        printUserInfo();
    }
    
    public static void printUserInfo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String userName = sc.next();

        System.out.println("请输入年龄：");
        int userAge = sc.nextInt();
        
        System.out.println(userName + "的年龄为：" + userAge);
    
    }
}

```





#### 输出

​	`System.out.println("Hello World");`



### 9、运算符

​	**大部分是和C语言类似的运算符规则。**

#### 例外：

1. **`+`**可以做连接符，例如输出的时候连接不同参数。**`+`**与**字符串**进行运算时，结果仍然是字符串。



### 10、DEMO：健康计算器应用程序

```java
package com.n1etzsch3.demo;

import java.util.Scanner;

public class AllTest {

    public static class User {
        String name;
        boolean gender;
        int age;
        double weight;
        double height;
        double BMI;
        double BMR;
    }

    public static void main(String[] args) {
        User user = new User(); // ✅ 初始化对象
        getUserInfo(user);
        getBMI(user);
        getBMR(user);
        printUserInfo(user);
    }

    public static void getUserInfo(User user){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户姓名：");
        user.name = sc.nextLine();
        System.out.println("请输入用户性别(0为女性\\1为男性)：");
        user.gender = sc.nextBoolean(); // true 为男，false 为女
        System.out.println("请输入用户年龄：");
        user.age = sc.nextInt();
        System.out.println("请输入用户体重（kg）：");
        user.weight = sc.nextDouble();
        System.out.println("请输入用户身高（m）：");
        user.height = sc.nextDouble();
    }

    public static void printUserInfo(User user){
        System.out.println("用户 " + user.name + " 的 BMI 为：" + user.BMI);
        System.out.println("BMR 为：" + user.BMR);
    }

    public static void getBMI(User user){
        user.BMI = user.weight / (user.height * user.height);
    }

    public static void getBMR(User user){
        if (user.gender) {
            user.BMR = 10 * user.weight + 6.25 * user.height * 100 - 5 * user.age + 5;
        } else {
            user.BMR = 10 * user.weight + 6.25 * user.height * 100 - 5 * user.age - 161;
        }
    }
}

```















