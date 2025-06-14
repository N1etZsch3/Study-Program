# Java设计模式

> 模式种类不全，以后慢慢补。

​	一个问题通常有n种解法，其中最优解称之为设计模式。设计模式有20多种，对应20多种软件开发中会遇到的问题。

## 一、创造性设计模式

### 1、单例模式

​	**作用：**确保某个类只能创建一个对象。

​	**写法：**1、类的构造器私有；2、定义一个类变量记录类的一个对象；3、定义一个类方法返回对象。

#### 懒汉式单例

```java
package com.n1etzsch3.singletondemo;

public class Singleton {
    // 2、定义一个静态变量用于记录本类的唯一对象。
    private static Singleton instance;

    // 1、私有化构造器，限制创造对象。
    private Singleton() {}

    // 3、提供一个公共方法，用于构建对象。
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
```

#### 饿汉式单例

```java
public class EagerSingleton {
    // 类加载时立即初始化
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    
    // 私有构造器防止外部实例化
    private EagerSingleton() {}
    
    // 全局访问点
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
```



## 二、模板方法设计模式

​	提供了一个方法作为完成某类功能的模板，模板方法封装了每个实现步骤，但允许子类提供特定步骤的实现。模板方法设计模式可以**提高代码的复用，简化子类设计**。



