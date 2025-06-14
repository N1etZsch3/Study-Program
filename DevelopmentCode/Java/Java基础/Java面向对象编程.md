# Java面向对象编程



## 一、类的基本操作

### 1、定义类

​	用`class`关键字定义一个类，注意类名首字母要大写。

```java	
package com.n1etzsch3.object;

public class Star {
  // 定义属性
    String name;
    String gender;
    int age;
    double height;
    double weight;
  
  // 定义方法
    public void printStarsInfo(){
        System.out.println("The star "+ name +"'s age is " + age +", and she is a " + gender + ", whose weight is "+ weight +" and height is " + height + " .");
    }
}

```

### 2、实例化类

​	实例化类用`new`关键字，`new`一个实例，对实例的属性和方法进行操作。

```java
package com.n1etzsch3.object;

public class Test {
    public static void main(String[] args) {
      // 实例化类（创建对象）
        Star s1 = new Star();
      // 初始化属性
        s1.name = "Yang Mi";
        s1.age = 30;
        s1.gender = "Girl";
        s1.weight = 50.1;
        s1.height = 171.2;
			// 调用方法
        s1.pringStarsInfo();
    }

}

```

> 同一个软件包下，Java类之间可以直接调用，不用import。



## 二、类的基本语法

### 1、构造器

​	构造器是一种特殊方法，**不能写返回值类型，名称必须是类名。**

#### 无参构造器

​	**类默认自带一个无参构造器。**

```java
package com.n1etzsch3.constructor;

public class Student {
    // 无参构造器
    public Student (){}
    
}

```



#### 有参构造器

​	**如果为类写了一个有参构造器，那么类默认的无参构造器将消失。如果还需要用无参构造器，就需要手动定义一个。**

```java
package com.n1etzsch3.constructor;

public class Student {
    // 有参构造器
    public Student (String n){}

}

```



#### 构造器重载

```java
package com.n1etzsch3.constructor;

public class Student {
    // 无参构造器
    public Student (){}
    
    // 有参构造器
    public Student (String n){}
    
    // 构造器重载
    public Student (String n, int a){}

}
```

> 由于构造器是一种特殊方法，所以重载也和方法重载的规则一样。



#### 构造器应用

​	类似于PHP的构造方法，**在创建对象时，对象会主动调用构造器，在创建对象的同时完成对对象属性的初始化赋值。**

##### 定义

```java
package com.n1etzsch3.constructor;

public class Student {
    String name;
    int age;
    String gender;

    public Student (){}

    public Student(String n, int a, String g){
        name = n;
        age = a;
        gender = g;
    }

    public void printStudentsInfo(){
        System.out.println(name + "'s age is " + age + ", and his gender is " + gender + ".");
    }

}

```

##### 调用

```java
package com.n1etzsch3.constructor;

public class Test {
    public static void main(String[] args) {

        Student s1 = new Student("Zhang san", 18, "Male");

        s1.printStudentsInfo();

    }
}

```



### 2、this关键字

​	`this`关键字可以指代当前对象，用于**解决变量名冲突问题**。以上面构造器代码为例。**标准要求每个变量名应当有意义而避免使用无意义字母**，所以上述代码应当改为：

```java
package com.n1etzsch3.constructor;

public class Student {
    String name;
    int age;
    String gender;

    public Student (){}

  // 构造函数中的参数命名应当有意义
    public Student(String name, int age, String gender){
      // 用this来指代当前对象
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void printStudentsInfo(){
        System.out.println(name + "'s age is " + age + ", and his gender is " + gender + ".");
    }

}

```



### 3、封装

​	**封装**是面向对象的三大特征之一，其他两个分别是：**继承**、**多态**。

#### 封装的设计要求：合理隐藏、合理暴露

#### 隐藏

​	使用`private`关键字修饰属性，使其只能在本类中直接访问，其他任何地方不能直接访问。

#### 暴露

​	使用`public`关键字修饰的`get`、`set`方法合理暴露。

#### 实例代码

##### 	定义

```java
package com.n1etzsch3.capsulation;

public class Student {
    private String name;
    private int age;
    private String gender;

    public Student(){};

    public Student(String name, int age, String gender){
        setName(name);
        setAge(age);
        setGender(gender);
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

}
```

##### 	调用

```java
package com.n1etzsch3.capsulation;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Zhang San", 18, "Male");
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(s1.getGender());
    }
}

```

#### 代码规范

1. Java规范要求所有类的属性统一用`private`关键字隐藏，并提供`public`方法`get`、`set`来访问属性。
2. 如果定义了有参构造器，一定要写一个无参构造器。
3. 所有方法的参数变量名必须有意义，在类中访问本对象属性必须用`this`关键字。



### 4、Javabean（实体类）

​	一种特殊的类，满足以下要求：

1. 类中的属性全部私有，提供对应的访问方法。
2. 类中需提供一个无参数的构造器，有参构造器可选。
3. 如果一个类中只有这些成分，没有定义其他东西，就称为一个实体类。

#### 示例代码

​	上面封装中的代码就是一个典型的实体类。

```java
package com.n1etzsch3.capsulation;

public class Student {
    private String name;
    private int age;
    private String gender;

    public Student(){};

    public Student(String name, int age, String gender){
        setName(name);
        setAge(age);
        setGender(gender);
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

}
```



#### 实体类的作用

​	实体类的基本作用是创建它的对象，存储数据。**实体类只负责数据的访问，对数据的其他处理往往会另外用一个方法类。**实现数据和数据业务的分离。例如：

##### 实体类定义

```java
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
```



##### 方法类定义

```java
package com.n1etzsch3.capsulation;

public class StudentOperator {
  // 方法类中有一个实体类对象
    private Student s;

    public StudentOperator(){}

  // 通过构造器将实体类对象传入方法类。
    public StudentOperator(Student s){
        this.s = s;
    }

    public Student getS() {
        return s;
    }

    public void printInfo(){
        System.out.println( s.getName() + " " + s.getAge() + " " + s.getGender());
    }

    public double getAverageGrade(){
        return (s.getChineseGrade() + s.getMathGrade() + s.getEnglishGrade()) / 3;
    }

    public void printAverage(){
        System.out.println(s.getName() + " " + getAverageGrade());
    }

    public double getTotalGrade(){
        return s.getChineseGrade() + s.getMathGrade() + s.getEnglishGrade();
    }

    public void printTotal(){
        System.out.println(s.getName() + " " + getTotalGrade());
    }
}

```



##### 调用

```java
package com.n1etzsch3.capsulation;

public class Test {
    public static void main(String[] args) {
      // 实例化对象
        Student s1 = new Student("Zhang San", 18, "Male", 112.1, 99.9, 100.0);
      // 实例化方法对象
        StudentOperator s1o = new StudentOperator(s1);
      // 调用方法
        s1o.printInfo();
        s1o.printAverage();
        s1o.printTotal();
    }
}

```



### 5、static关键字

#### `static`修饰变量

​	和C语言中`static`关键字的作用类似，用于将一个变量声明为静态变量存放在堆中。在Java中，静态变量又叫类变量，是所有该类实例化后的对象都可访问的公共变量，它属于类本身，仅此一份，所有对象都可访问修改。

​	对类变量的访问可以用`className.varable`也可以是`objectName.varable`。但推荐使用类名来访问静态变量。

​	它一般的应用场景可以是记录类的对象个数的。例如：

```java
package com.n1etzsch3.staticfiled;

public class Student {
  // 记录学生数量
    public static int count = 0;

  // 通过构造器，每次实例化类，都迭代count。
    public Student(){
      // 用类名来访问类变量。
        Student.count++;
    }

}

```

#### `static`修饰方法

​	用`static`修饰方法，那么该方法属于类，所有对象均可访问。对静态方法的调用推荐使用`类名.静态方法`。如果一个方法只为做一个功能而不用直接访问对象数据，这个方法就直接定义为静态方法。还可以用于做工具类。

##### 工具类

​	工具类中的方法都是静态的，每个类方法用于完成一个功能。能提高代码的复用率。实例方法在调用时需要创建对象，而类方法不需要创建对象，节约了内存。也正是因为工具类不需要创建对象，所以建议将工具类的构造器私有化。

```java
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

```

> **类方法不可以出现`this`关键字**。

