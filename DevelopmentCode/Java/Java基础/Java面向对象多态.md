# 多态

**多态是继承/实现情况下的一种现象，表现为：对象多态、行为多态。**



## 示例代码

**父类**

```java
package com.n1etzsch3.polymorphism;

public class Animal {
    String name = "Animal";

    public void run(){
        System.out.println("Animals can run!");
    }
}

```

**子类1**

```java
package com.n1etzsch3.polymorphism;

public class Tortoise extends Animal {
    String name = "Tortoise";

    @Override
    public void run(){
        System.out.println("Tortoises run slowly!");
    }

}

```

**子类2**

```java
package com.n1etzsch3.polymorphism;

public class Wolf extends Animal {
    String name = "Wolf";

    @Override
    public void run(){
        System.out.println("Wolves run fast!");
    }

}

```

**调用**

```java
package com.n1etzsch3.polymorphism;

public class Test {
    public static void main(String[] args) {
        Animal a1 = new Tortoise();
      // 方法：编译看左边(Animal a1)，运行看右边(调用Tortoise中重写的run方法)。
        a1.run();  
      // 属性：// 编译看左边(Animal a1)，运行也看左边(Animal中的name属性的值)。
        System.out.println(a1.name);

        Animal a2 = new Wolf();
        a2.run();
        System.out.println(a2.name);
    }
}

```

**输出**

```shell
Tortoises run slowly!
Animal
Wolves run fast!
Animal	
```

>  **从输出可见，多态只包含了对象多态和行为多态，并没有包含属性多态，属性还是父类属性。**



## 多态的前提

1. **有继承/实现关系，即有子父类存在。`public class Tortoise extends Animal{}`**
2. **存在父类引用子类对象。即`Animal a1 = new Tortoise();`。**
3. **存在方法重写。`@Override`。**

> **再次强调！多态是对象、行为的多态，Java中的属性没有多态！**



## 多态的优点

​	**在多态形式下，对象是解耦合（模块化设计）的，更便于扩展和维护。定义方法时，使用父类类型的形参，可以接收一切子类对象，扩展性更强，更便利。**

```java
package com.n1etzsch3.polymorphism;

public class Test {
    public static void main(String[] args) {
        Animal a1 = new Tortoise();
        Animal a2 = new Wolf();
        
        go(a1);
        go(a2);
    }
    
  // 只需要用父类形参，就可以接收一切子类对象，调用子类自身的方法。
    public static void go(Animal animal) {
        System.out.println("Start running!");
        animal.run();
    }
}

```



## 多态的问题

**多态下不能调用子类独有功能！**

**乌龟类**

```java
package com.n1etzsch3.polymorphism;

public class Tortoise extends Animal {
    String name = "Tortoise";

    @Override
    public void run(){
        System.out.println("Tortoises run slowly!");
    }

    public void pullIntoShell(){
        System.out.println("Tortoises pull themselves into shell!");
    }

}

```

**调用**

```java
package com.n1etzsch3.polymorphism;

public class Test {
    public static void main(String[] args) {
      // 多态下不能使用子类的独有功能。
        Animal a1 = new Tortoise();
      // 编译看Animal类，Animal类中没有pullIntoShell方法。
      	a1.pullIntoShell();
      
      // 必须创建一个子类对象才能使用子类独有功能。
     		Tortoise t1 = new Tortoise();
        t1.pullIntoShell();
    }
}

```



## 多态类型转换

**强制类型转换：`子类 变量名 = (子类)父类变量;`**例如：

```java
Animal a1 = new Tortoise();
// 将a1转换为Tortoise类型。
Tortoise t1 = (Tortoise)a1;
```

注意：

1. 存在继承/实现关系就可以在编译阶段进行强制类型转换，编译阶段不会报错。
2. 运行时，如果发现对象的**真实类型**与强转后的类型不同，就会报**类型转换异常`ClassCastException`**的错误。

**错误示范**

```java
Animal a1 = new Tortoise();
// 将a1转换为Wolf类型。
Wolf w1 = (Wolf)a1;
// 报类型转换异常错误。
```

**因此，在强制类型转换时，往往用`instanceof`关键字来判断对象的真实类型。**

**正确示范**

```java
Animal a1 = new Tortoise();
// 将a1转换为Tortoise类型。
if(a1 instanceof Wolf){
  	Wolf w1 = (Wolf)a1;
}
else if(a1 instanceof Tortoise){
  	Tortoise t1 = (Tortoise)a1;
}
```

