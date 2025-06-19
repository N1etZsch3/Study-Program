# Java面向对象高级



## 一、`final`关键字

​	`final`即为最终的意思，可用于修饰：类、方法、变量。

### 修饰类：

​	该类就被称为最终类，特点是不能被继承。`final class A{}`工具类一般用`final`修饰，因为其不需要再被继承。

### 修饰方法：

​	该类就被称为最终方法，特点是不能被重写。`public final void method(){}`

### 修饰变量：

​	该变量有且仅能被赋值一次。对于一些不会再发生改变的变量可以用`final`修饰。类似于C语言中的常量概念。`final double PI =3.1415926535; `一般`final`修饰的变量名全大写，多个单词下划线隔开。例如之前做过的一个金卡折扣倍率，就用到了`private static final double DISCOUNT = 0.8;`。通常用于系统配置信息。

> `final`修饰基本类型变量，变量存储的数据不能被改变。
>
> `final`修饰引用类型的变量，变量存储的地址不能被改变，但是地址所指向的对象的内容可以被改变。

### 常量：

​	使用`static final`修饰的量就是常量，通常用于记录系统的配置信息。程序编译后，常量会被“宏替换”，这样可以保证使用常量和直接使用字面量的性能是一样的。





## 三、枚举类

​	枚举类很适合做信息分类和标志，例如：

**枚举类定义：**

```java
package com.n1etzsch3.enumdemo;

public enum Season {  // 使用enum关键字声明这是一个枚举类
    // ▼ 1. 枚举常量声明（核心部分）▼
    SPRING("春天", "温暖"),   // 创建SPRING实例，传入参数
    SUMMER("夏天", "炎热"),   // 创建SUMMER实例，传入参数
    AUTUMN("秋天", "凉爽"),   // 创建AUTUMN实例，传入参数
    WINTER("冬天", "寒冷");   // 创建WINTER实例，传入参数 [注意结尾用分号!]

    // ▼ 2. 成员变量（封装数据）▼
    private final String name;  // 季节名称（final确保不可变）
    private final String desc;   // 季节描述（final确保不可变）

    // ▼ 3. 构造方法（关键连接点）▼
    Season(String name, String desc) {  // 参数与枚举常量传入值匹配
        this.name = name;  // SPRING("春天",..) → 此处 this.name = "春天"
        this.desc = desc;  // SPRING("春天",..) → 此处 this.desc = "温暖"
    }

    // ▼ 4. 访问方法（获取数据）▼
    public String getName() { return name; }   // 获取季节名
    public String getDesc() { return desc; }   // 获取季节描述

    // ▼ 5. 重写toString方法（自定义输出）▼
    @Override
    public String toString() {
        return name + "：" + desc;  // 示例：SPRING → "春天：温暖"
    }
}

```



**调用：**

```java
package com.n1etzsch3.enumdemo;

public class Test {
    public static void main(String[] args) {
        // 获取枚举实例
        Season current = Season.SUMMER;

        // 访问数据
        System.out.println(current.getName());  // 输出：夏天
        System.out.println(current.getDesc());  // 输出：炎热

        // 自动调用toString()
        System.out.println(current);  // 输出：夏天：炎热

        // 获取所有枚举值
        for (Season s : Season.values()) {
            System.out.println(s.name() + " - " + s.getDesc());
        }
    }
}

```



## 四、抽象类

​	使用关键字`abstract`修饰类、成员方法，其分别为抽象类和抽象方法。

### 抽象类特点

1. 抽象类中不一定要有抽象方法，但是有抽象方法的类必须是抽象类。
2. 类有的成员：属性、方法、构造器，抽象类都可以有。
3. <font color=red>**抽象类最主要的特点：**抽象类不能创建对象，仅作为一种特殊的父类，让子类继承并实现。</font>
4. <font color=red>一个类继承抽象类，**必须重写完抽象类的全部抽象方法**，否则这类也必须定义成抽象类。</font>
5. **抽象类的意义就是被继承。**

### 代码实现

**定义**

```java
package com.n1etzsch3.abstractdemo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractDemo {
  // 抽象类可以有成员变量
    private int num;
    private String name;

    // 抽象方法：没有方法体，子类必须实现
    public abstract void a();  // 子类必须实现此方法

    public abstract void b();
    
    public abstract void c();
  
  // 抽象类可以有成员方法  
    public void display() {
        System.out.println("Display method in AbstractDemo.");
    }

}

```

**调用**

```java
package com.n1etzsch3.abstractdemo;

public class AbstractDemo2 extends AbstractDemo{

  // 继承抽象类的子类，必须重写全部抽象方法。
    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }
}

```



### 案例

+ 某宠物游戏，需要管理猫和狗。

+ 猫的数据有：名字；行为是：喵喵叫。
+ 狗的数据有：名字；行为是：汪汪叫。

**动物类（抽象类）**

```java
package com.n1etzsch3.abstractdemo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Animal {
    private String name;

    public abstract void cry();

}

```

**猫类（子类1）**

```java
package com.n1etzsch3.abstractdemo2;

public class Cat extends Animal {

    @Override
    public void cry() {
        System.out.println("🐱喵喵喵！");
    }
}

```

**狗类（子类2）**

```java
package com.n1etzsch3.abstractdemo2;

public class Dog extends Animal{

    @Override
    public void cry() {
        System.out.println("🐶汪汪汪！");
    }
}

```

**调用**

```java
package com.n1etzsch3.abstractdemo2;

public class Main {
    public static void main(String[] args) {
      // 多态
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.setName("咪咪");
        dog.setName("大黄");

        cat.cry();
        dog.cry();

        System.out.println(cat);
        System.out.println(dog);
    }
}

```



## 接口

### 定义接口	

​	使用关键字`interface`定义接口。<font color=red>**接口不能创建对象。**</font>

**示例代码**

```java
package com.n1etzsch3.interface1;

// 使用interface关键字定义。
public interface A {
    // JDK8之前，接口中只能定义常量和抽象方法。修饰符必须是public。

    // 1、常量：在接口中，常量的static final可以省略不写。下述二者等效。
    String NAME1 = "张三";
    public static final String NAME2 = "李四";

    // 2、抽象方法：在接口中，抽象方法的abstract可以省略不写。下述二者等效。
    public abstract void a();
    void b();
}

```



### 实现类

​	接口是用来被类实现(**`implements`**)的，实现接口的类叫**实现类**，一个类可以实现多个接口。

**示例代码**

```java
package com.n1etzsch3.interface1;

// 实现类实现多个接口必须重写完所有接口的全部抽象方法，否则这个类必须被定义为抽象类。
public class C implements A, B{
    @Override
    public void play() {
        
    }

    @Override
    public void show() {

    }

    @Override
    public void run() {

    }

    @Override
    public void jump() {

    }
}

```



### 接口的好处

+ 弥补了类单继承的不足，一个类可以同时实现多个接口，使类的角色更多，功能更强大。
+ 让程序可以**面向接口编程**，这样程序员就可以灵活方便的切换各种业务实现。更利于程序解耦合。

**示例代码**

```java
package com.n1etzsch3.interface2;

public class Main {
    public static void main(String[] args) {
      // Student类可以实现更多的角色，使类更强大。
        people p = new Student();
        Driver d = new Student();
        Cooker c = new Student();
        Teacher t = new Student();
        
    }
}

interface Driver{}

interface Cooker{}

interface Teacher{}

class people{}

class Student extends people implements Driver, Cooker, Teacher{}

```



### JDK8之后，接口新增的三种方法

#### 1、默认方法

​	使用关键字**`default`**方法修饰，默认会被加上**`public`**修饰。

```java
public interface A {
  // 默认方法
  default void go(){
    System.out.println("Let's go!");
  }
}
```

​	只能使用接口的**实现类**方法调用。

```java
package com.n1etzsch3.interface3;

public class Main {
    public static void main(String[] args) {
        AImpl a = new AImpl();
        a.go();
    }
}

// 通过接口的实现类调用接口的默认方法。
class AImpl implements A{

}

```



#### 2、私有方法

​	接口中的私有方法只能由接口中其他实例方法来调用。

```java
package com.n1etzsch3.interface3;

public interface A {
  // 默认方法调用私有方法
    default void go(){
        System.out.println("Let's go!!!");
        run();
    }

  // 私有方法。
    private void run(){
        System.out.println("Running is fast going!");
    }

}

```



#### 3、静态方法（类方法）

​	静态方法只能使用当前接口名来调用。不允许用实现类调用方法。

```java
package com.n1etzsch3.interface3;

public interface A {
	// 静态方法
    static void show(){
        System.out.println("Showing means to print information!");
    }

}

```



### 接口注意事项

#### <font color=red>1、接口与接口可以多继承：一个接口可以同时继承多个接口。</font>

+ 类与类：单继承，一个类只能继承一个直接父类。
+ 类与接口：多实现，一个类可以同时实现多个接口。
+ 接口与接口：多继承，一个接口可以同时继承多个接口。

```java
interface A{}

interface B{}

interface C extends A, B{}

// 实现类D可以同时实现A、B、C三个接口。
class D implements C{}
```



#### 2、一个接口继承多个接口，如果多个接口中存在方法签名冲突，则此时不支持多继承和多实现。

**方法签名冲突：**

```java
interface A{
  void show();
}

interface B{
  void show();
}

// 此时代码不会报错，因为两个方法完全一样，被规范合并成一个方法。
interface C extends A, B{}

interface A1{
  void show();
}

interface B1{
  String show();
}

// 此时代码报错，因为两个方法存在签名冲突。
interface C1 extends A1, B1{}
```



#### 3、一个类继承了父类，又同时实现了接口，如果父类中和接口中有同名的方法，实现类会优先用父类。



#### 4、一个类实现了多个接口，如果多个接口中存在同名的默认方法，要想不冲突，则这个类要重写该方法。

```java
interface A{
  void show();
}

interface B{
  void show();
}

// 重写这个方法就不会报错，否则会报错。
class C implements A, B{
  @Override
  public void show(){};
}
```



### 抽象类和接口的区别

#### 相同点：

+ 都是抽象形式，都可以有抽象方法，都不能创建对象。
+ 都是派生子类形式：抽象类被子类继承使用，接口被实现类实现。
+ 继承抽象类或实现接口都必须重写完他们的抽象方法。
+ 都能支持多态，都能实现解耦合

#### 不同点

+ 抽象类可以定义类的全部成员，接口只能定义**常量、抽象方法（JDK8新增三种方法）**。
+ 抽象类只能被单继承，但接口可以被多实现。
+ 一个类继承了抽象类就不能再继承其他类，但一个类实现了接口还可以继承其他类或实现其他接口。
+ 抽象类体现模板思想：更利于做父类实现代码的复用性。
+ 接口更适合做功能的解耦合：解耦性更强。
