# Java高级

​	在Java中，类有5大成分：成员变量（属性）、构造器、方法、代码块、内部类。

## 代码块

### 静态代码块

**格式：**

```java
static{
  // 代码
}
```

**特点：**静态代码块由类所有，类加载时自动执行，由于类只加载一次，所以静态代码块也只会执行一次。

**作用：**完成类的初始化，例如：对静态变量的初始化赋值。

**示例代码**

```java
package com.n1etzsch3.code;

public class Main {

    static {
        System.out.println("Static block executed");
    }

    public static void main(String[] args) {
        System.out.println("Main method started");
    }
}

```

**输出**

```java
Static block executed
Main method started
```

> **静态方法先于main函数执行**



### 实例代码块

**格式：**

```java
{
  // 实例代码块
}
```

**特点：**每次创建对象时执行，**并在构造器之前执行。**

**作用：**完成对象的初始化。

**示例代码**

```java
package com.n1etzsch3.code;

public class Main {

    {
        System.out.println("Instance initializer block executed");
    }

    public static void main(String[] args) {
        System.out.println("Main method started");
        Main mainInstance = new Main();
    }
}

```

**输出**

```java
Main method started
Instance initializer block executed
```

> **实例方法在main方法之后执行**



## 内部类

​	**一个类定义在另一个类里面，就叫内部类。**

### 成员内部类

**成员内部类定义**

```java
package com.n1etzsch3.innerclass;

// 外部类
public class Outer {
    // 成员内部类：无static修饰，属于外部类的对象所有。
    public class Inner {
        public void display() {
            System.out.println("This is an inner class method.");
        }
    }

}
```



**成员内部类的实例化**

```java
package com.n1etzsch3.innerclass;

public class InnerClassDemo1 {
    public static void main(String[] args) {
        // 创建成员内部类对象格式：
        // 外部类名.内部类名 对象名 = new 外部类名().new 内部类名();
        Outer.Inner inner = new Outer().new Inner();
        inner.display();
    }
}
```



**成员内部类访问外部类外部类成员的特点：**

1. 成员内部类可以直接访问外部类的**静态成员**和**实例成员**。
2. 成员内部类的实例方法中，可以直接拿到当前寄生的外部类对象：外部类名.this



**一个笔试题**

```java
package com.n1etzsch3.innerclass;

public class InnerClassDemo1 {
    public static void main(String[] args) {
        // 创建成员内部类对象格式：
        // 外部类名.内部类名 对象名 = new 外部类名().new 内部类名();
        People.Heart ph = new People().new Heart();
        ph.beat();
    }
}

// 一个笔试题：
class People{
    private int heartBeat = 100;

    public class Heart {

        private int heartBeat = 80;

        public void beat() {
            int heartBeat = 60;
            // 要求：三行代码分别输出心跳值
            // 100
            System.out.println(People.this.heartBeat);
            // 80
            System.out.println(this.heartBeat);
            // 60
            System.out.println(heartBeat);

        }
    }
}
```



### 静态内部类

​	使用**`static`**关键字修饰，属于外部类自己持有。

**静态内部类定义**

```java
package com.n1etzsch3.innerclass;

// 外部类
public class Outer {
    // 静态内部类
    public static class Inner {
        public void display() {
            System.out.println("This is an inner class method.");
        }
    }

}
```



**静态内部类实例化**

```java
package com.n1etzsch3.innerclass;

public class InnerClassDemo1 {
    public static void main(String[] args) {
        // 创建静态内部类的实例语法
        // Outer.Inner inner = new Outer.Inner();
        Outer.Inner inner = new Outer.Inner();
        // 调用静态内部类的方法
        inner.display();
    }
}
```

<font color=red>静态内部类**可以直接访问外部类的静态成员，不能直接访问外部类的实例成员！**</font>



### 局部内部类

**没啥用的语法......😓**



### <font color=red>匿名内部类（非常重要的技术）</font>

**匿名：不需要为这个类声明类名，默认有一个隐藏的名字。**

**本质：匿名内部类本质是一个子类，并且会立即创造出一个子类对象。**

**作用：用于更方便创建一个子类对象。**

**代码示例：**

```java
// ================Animal.java===========
package com.n1etzsch3.innerclass2;

public abstract class Animal {
    public void cry(){}
}


// ================Main.java===============
package com.n1etzsch3.innerclass2;

public class Main {
    public static void main(String[] args) {
      	
      	// 匿名内部类的实现和调用
        Animal cat = new Animal() {
            @Override
            public void cry() {
                System.out.println("Meow");
            }
        };  // 注意有分号。

      	// 匿名内部类本质是一个子类，同时会立即创建一个子类对象。
      
        cat.cry();

    }
}

```

> <font color=red>**本质是把之前需要先创建一个子类继承抽象父类，再实例化子类的过程糅合成了一步。**</font>

**匿名内部类反编译后的源码为：**

```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.n1etzsch3.innerclass2;

// 可以看到匿名内部类是有名字的，只不过隐藏了
// 命名规则为：外部类名$编号.class
// 本质是创建一个子类继承父类，同时实例化一个子类对象。
class Main$1 extends Animal {
    public void cry() {
        System.out.println("Meow");
    }
}

```



#### 匿名内部类在开发中的常见形式

+ <font color=red>**通常作为一个对象参数传输给方法**</font>

**代码示例**

```java
package com.n1etzsch3.innerclass2;

public class Test {
    public static void main(String[] args) {
      // 使用匿名内部类参数实现Skill接口
        swim(new Skill() {;
            @Override
            public void swimming() {
                System.out.println("Student Swimming skill implemented.");
            }
        });

        swim(new Skill() {
            @Override
            public void swimming() {
                System.out.println("Teacher Swimming skill implemented.");
            }
        });
    }

    public static void swim(Skill skill) {
        skill.swimming();
    }
}

interface Skill {
    void swimming();
}
```

**其原本相当于**

```java
package com.n1etzsch3.innerclass2;

public class Test {
    public static void main(String[] args) {
        Skill s = new Student();
        swimming(s);
        s = new Teacher();
        swimming(s);
    }

    public static void swimming(Skill skill) {
        skill.swimming();
    }
}

class Student implements Skill {
    @Override
    public void swimming() {
        System.out.println("Student Swimming skill implemented.");
    }
}

class Teacher implements Skill {
    @Override
    public void swimming() {
        System.out.println("Teacher swimming skill implemented.");
    }
}

interface Skill {
    void swimming();
}
```



#### 匿名内部类在开发中的真实使用场景示例

+ **调用别人提供的方法实现需求时，这个方法正好可以让我们传输一个内部匿名类对象给其使用。**

```java
package com.n1etzsch3.innerclass2;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Test2 {
    public static void main(String[] args) {
        // 创建一个窗口
        JFrame win = new JFrame("Test2");

        // 设置窗口的大小、位置和关闭操作
        win.setSize(300, 200);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个面板，并将其添加到窗口中
        JPanel panel = new JPanel();
        win.add(panel);

        // 在面板上添加一个按钮
        JButton btn = new JButton("Log In");
        panel.add(btn);

        // java要求为按钮绑定一个事件监听器
        // 方法：addActionListener的参数是一个实现了ActionListener接口的对象
        // 使用匿名内部类来实现ActionListener接口
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });

        // 设置窗口可见
        win.setVisible(true);
    }
}

```

**其中，使用匿名内部类的代码可以更加简洁简化：**

```java
// 使用匿名内部类实现接口。
btn.addActionListener(new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
});

// 该代码可以简化为：
btn.addActionListener(e -> System.out.println("Button clicked!"));
```



**示例代码：将一个学生类数组按某种规则排序输出。**

**学生类定义**

```java
package com.n1etzsch3.innerclass2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    // 姓名、年龄、性别、身高
    private String name;
    private int age;
    private String gender;
    private double height;
}

```

**主代码实现**

```java
package com.n1etzsch3.innerclass2;

import java.util.Arrays;
import java.util.Comparator;

public class Test3 {
    public static void main(String[] args) {
        // 完成给数组排序，使用匿名内部类
        // 创建一个学生类型的数组，存放六个学生对象
        Student[] students = new Student[6];
        students[0] = new Student("张三", 20, "男", 1.75);
        students[1] = new Student("李四", 22, "女", 1.65);
        students[2] = new Student("王五", 21, "男", 1.80);
        students[3] = new Student("赵六", 19, "女", 1.70);
        students[4] = new Student("钱七", 23, "男", 1.78);
        students[5] = new Student("孙八", 20, "女", 1.60);

        // 按照年龄升序排序
        sortStudentsByAge(students);

        // 显示所有学生信息
        showAllStudents(students);

    }

    public static void showAllStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void sortStudentsByAge(Student[] students){
        // 按年龄升序排序，通过调用API对数组排序：
        // public static void sort(Object[] a, Comparator<? super Object> c)
        //                        参数一：要排序的数组
        //                        参数二：给sort一个Comparator比较器对象（接口）（指定排序规则）
        // sort方法会调用Comparator接口的compare方法来比较两个对象的大小关系，实现排序功能。
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 按年龄升序排序
                // 返回负数表示o1小于o2，返回正数表示o1大于o2，返回0表示相等
                return o1.getAge() - o2.getAge(); // 按年龄升序排序
                // return o2.getAge() - o1.getAge(); // 按年龄降序排序
            }
        });
    }

}

```



## 函数式编程

​	<font color=red>Java中**函数**被认为是**`Lambda表达式: (x) -> 2x+1`**，而不是C语言意义上的函数	</font>

+ 使用`Lambda`表达式可以代替某些匿名内部类对象，从而让程序代码更简洁，可读性更好。

**格式：**

```java
(被重写方法的形参列表) -> {
  	被重写方法的方法体代码。
}
```

**错误示例：**

```java
package com.n1etzsch3.lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        // 使用Lambda表达式代替匿名内部类对象
        // 代码报错，因为Lambda并不能简化所有匿名内部类。
        // Lambda只能简化函数式接口的匿名内部类。
        Animal cat = () -> System.out.println("🐱");
    }
}

abstract class Animal{
    public abstract void cry();
}
```

### 函数式接口

<font color=red>接口必须**仅有一个抽象方法**（可包含多个默认/静态方法）</font>

**错误示范**

```java
// 多抽象方法的接口 ❌ 不能用 Lambda
interface Invalid {
    void method1();
    int method2(String s);
}

// 编译错误：Target type of a lambda conversion must be an interface
Invalid invalid = () -> System.out.println("Fail"); 
```

**正确示范**

```java
package com.n1etzsch3.lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        // 使用Lambda表达式代替匿名内部类对象
        Skill student = () -> System.out.println("🧒Student can swim!");
        student.swimming();
    }
}

// 函数式接口
@FunctionalInterface
interface Skill{
    void swimming();
}


```

**上面对学生数组排序的方法可以简写为：**

```java
Arrays.sort(students, new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
        // 按年龄升序排序
        // 返回负数表示o1小于o2，返回正数表示o1大于o2，返回0表示相等
        return o1.getAge() - o2.getAge(); // 按年龄升序排序
        // return o2.getAge() - o1.getAge(); // 按年龄降序排序
    }
});

Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
```



### `Lambda`表达式省略规则

+ **参数类型可以全部省略不写。**
+ **如果只有一个参数，参数类型省略的同时`()`也可以省略，但多个参数不能。**
+ **如果`Lambda`表达式中只有一行代码，大括号可以不写，同时要省略分号`;`，如果这行代码是`return`，则`return`也必须去掉。**

**例如：**

```java
package com.n1etzsch3.lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        // 使用Lambda表达式代替匿名内部类对象
        String name = "🧑‍🎓";
        Skill s = n -> n+"Student can swim!";
        System.out.println(s.swimming(name));
    }
}

@FunctionalInterface
interface Skill{
    String swimming(String name);
}

=========================================================

 Skill s = n -> n+"Student can swim!";
// 这句简化的Lambda就相当于
Skill s = (String n) -> {return n+"Student can swim!";};
```



### 方法引用

​	**使Lambda表达式能够更简洁。**

#### 静态方法引用

**格式：**`类名::静态方法`

**使用场景：**如果某个Lambda表达式里只是调用一个静态方法，并且“->”前后参数的形式一致，就可以使用静态方法引用。

**示例：**

```java
// 以上面给学生类排序为例
public static void sortStudentsByAge(Student[] students){
    // 按年龄升序排序，通过调用API对数组排序：
    // public static void sort(Object[] a, Comparator<? super Object> c)
    Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
}

// 其中Lambda的函数体部分o1.getAge() - o2.getAge()可以在Student中定义一个静态方法：

package com.n1etzsch3.methodreference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    // 姓名、年龄、性别、身高
    private String name;
    private int age;
    private String gender;
    private double height;
    
    public static int compareByAge(Student s1, Student s2) {
        return s1.getAge() - s2.getAge();
    }
    
}

// 则上述方法就可以简化为：
Arrays.sort(students, (o1, o2) -> Student.compareByAge(o1, o2));

// 根据静态方法引用规则，只调用一个静态方法，参数列表相同，则可以简化为：
Arrays.sort(students, Student::compareByAge);
```



#### 实例方法引用

**格式：**`对象名::实例方法`

**使用场景：**如果某个Lambda表达式里只是通过对象名称调用一个实例方法，并且"->"前后参数一致，就可以使用实例方法引用。

```java
// 与静态方法引用类似的是，先要在类中定义一个实例方法：
public int compareByHeight(Student s1, Student s2) {
    return Double.compare(s1.getHeight(), s2.getHeight());
}

// 与静态方法引用不同的是，在使用的时候要先实例化一个对象，再用对象调用实例方法。
public static void sortStudentsByHeight(Student[] students){
    Student s = new Student();
    Arrays.sort(students, s::compareByHeight);
}
```



#### 特定类型方法的引用

**格式：**`特定类的名称::方法`

**使用场景：**如果某个Lambda表达式里只是调用一个特定类型的实例方法，并且前面参数列表中的第一个参数是作为方法的主调，后面所有的参数是作为方法的入参，则此时可以使用特定类型方法引用。

```java
// 需求：对一个名字数组进行不分大小写字母的排序。
package com.n1etzsch3.methodreference;

import java.util.Arrays;
import java.util.Comparator;

public class Demo1 {
    public static void main(String[] args) {

        String[] names = {"Tom", "jeery", "Alice", "Charlie", "andy", "Eva", "frank", "张三", "Lily", "Bob"};

      	// 使用匿名内部类实例化比较器。
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);  // 方法compareToIgnoreCase可以忽略字母大小写进行排序。第一个参数为主调，第二个参数为入参。
            }
        });

        System.out.println(Arrays.toString(names));

    }
}

// 则上述核心代码
Arrays.sort(names, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
});

// 可以简化为：
Arrays.sort(names, String::compareToIgnoreCase);
```



#### 构造器引用

<font color=red>目前看不懂😓</font>

