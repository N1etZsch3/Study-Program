# 继承

​	**Java提供关键字`extends`使一个类和另一个类建立父子关系，叫继承。**被继承的类叫**父类**，继承的类叫**子类**。

​	语法为：`public class B extends A{}`。A为父类，B为子类。

## 代码示例

### 父类

```java
package com.n1etzsch3.extendsdemo;

public class People {

    private String name;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}

```

### 子类`Teacher`

```java
package com.n1etzsch3.extendsdemo;

public class Teacher extends People{
    private String skills;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}

```

### 子类`Consultant`

```java
package com.n1etzsch3.extendsdemo;

public class Consultant extends People {
    private int usersCount;

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }
}

```

### 调用

```java
package com.n1etzsch3.extendsdemo;

public class Test {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setName("N1etZsch3");
        t1.setAge(20);
        t1.setGender("Male");
        t1.setSkills("Java, Python, C++");

        System.out.println(t1.getName()
                + "is a "
                + t1.getAge()
                + " years old boy, and he can use "
                + t1.getSkills()
                + ".");

        Consultant c1 = new Consultant();
        c1.setName("Zhang San");
        c1.setAge(20);
        c1.setGender("Female");
        c1.setUsersCount(20);

        System.out.println(c1.getName()
                + " is a "
                + c1.getAge()
                + " years old girl, and she has "
                + c1.getUsersCount()
                + " clients.");
    }
}

```



## 注意事项

### 权限修饰符

+ **`private`**：只能本类（不包括子类）能够访问。
+ **缺省（什么修饰符都没有）**：本类，同一个包中的类能够访问
+ **`protected`**：本类，子孙类，同一个包中的类可访问。
+ **`public`**：任意位置均可访问。



### 继承的特点

#### 单继承  多层继承

​	一个Java类**只能有一个父类**，不支持有多个父类，但支持多层继承。

**错误示范**

```java
package com.n1etzsch3.extendsfeature;

public class Test {
    public static void main(String[] args) {

    }
}

class GrandFather{}

class Father{}

// 不支持多继承（一个儿子认多个父亲）
class Son extends Father, GrandFather{}

```

**正确示范**

```java
package com.n1etzsch3.extendsfeature;

public class Test {
    public static void main(String[] args) {

    }
}

class GrandFather{}

class Father extends GrandFather{}

// 支持多层继承
class Son extends Father{}

```

> **一个Java文件中最好只有一个`public`类。**



#### 祖宗类

​	Java中所有的类都有一个祖宗类`object`要么默认继承`object`，要么间接继承`object`。



#### 就近原则

​	在子类方法中访问其他成员变量，依照就近原则，现在子类局部范围找，然后子类成员范围找，然后父类成员范围找。如果父类范围还没有找到就报错。



#### `super`关键字

​	如果子父类出现了重名成员，会优先使用子类的，如果此时一定要在子类中使用父类，要用`super`关键字，指定访问父类成员。`super.父类成员`。

```java
package com.n1etzsch3.extendsfeature;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}

class Father{
    String name = "Father";
}

class Son extends Father{
    String name = "Son";

    public void show(){
      // 输出子类名称
        System.out.println(this.name);
      // 输出父类名称
        System.out.println(super.name);
    }
}

```



## 方法重写

​	子类认为父类方法无法满足业务需求，可以重写一个**方法名称，参数列表和父类方法一样**的方法，覆盖父类方法，称为方法重写。用`@Override`注解。

```java
package com.n1etzsch3.extendsoverride;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.sayHello();
    }
}

class Father{
    public void sayHello(){
        System.out.println("I am father");
    }
}

class Son extends Father{
    @Override   // 方法重写的校验注解（标志），要求方法名称、形参列表必须与被重写方法一致。
    public void sayHello(){
        System.out.println("I am son");
    }
}

```



### 注意事项

1. **子类重写父类方法时，访问权限必须大于或等于父类该方法的权限（`public` > `protected` > `缺省` ）。**
2. **重写方法的返回值类型，必须与被重写方法返回值类型一致或更小。**
3. **私有方法，静态方法不能被重写！**

> **总之一条：声明不变，重新实现。**即，父类如何声明一个方法，子类照抄，重写其实现代码部分，不更改其声明部分。



### 应用场景

**方法重写在开发中一个最经典的应用场景就是重写`Object`类中的`toString`方法。**

**`Object`类的`toString`方法用于返回当前对象的地址。**

**调用`System.out.println(ClassName);`等价于`System.out.println(ClassName.toString());`。**

例如：

```java
package com.n1etzsch3.extendsoverride;

public class Test2 {
    public static void main(String[] args) {
        Student s1 = new Student("Zhang San", 18, "Male");

        System.out.println(s1);
        System.out.println(s1.toString());
        
    }
}

class Student{
    private String name;
    private int age;
    private String gender;

    public Student(){}

    public Student(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

```

其输出为：

```shell
com.n1etzsch3.extendsoverride.Student@5f184fc6
com.n1etzsch3.extendsoverride.Student@5f184fc6
```

可见`System.out.println(ClassName);` 与 `System.out.println(ClassName.toString());` 等价。

而要想使`toString`输出对象的具体信息而不是地址，则需要重写`toString`方法。

```java
package com.n1etzsch3.extendsoverride;

public class Test2 {
    public static void main(String[] args) {
        Student s1 = new Student("Zhang San", 18, "Male");

        System.out.println(s1);

    }
}

class Student{
    private String name;
    private int age;
    private String gender;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Student(){}

    public Student(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

```

输出为：

```shell
Student{name='Zhang San', age=18, gender='Male'}
```



## 子类构造器



### 语法规范

##### **子类的全部构造器都必须先调用父类的构造器，再执行自己。**

```java
package com.n1etzsch3.extendsconstructor;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Father{
    public Father(){
        System.out.println("Father's constructor is being called");
    }
}

class Son extends Father{
    public Son(){
        System.out.println("Son's constructor is being called");
    }
}

```

输出为：

```shell
Father's constructor is being called
Son's constructor is being called
```

##### **如果父类的构造器私有，则子类构造器无法调用，这说明子类构造器必须先调用父类构造器。**

```java
package com.n1etzsch3.extendsconstructor;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Father{
  // 父类构造器私有
    private Father(){
        System.out.println("Father's Parameterless constructor is being called");
    }
}

class Son extends Father{
  // 子类构造器报错。
    public Son(){
        System.out.println("Son's Parameterless constructor is being called");
    }
}

```

##### **如果父类是有参构造器，则子类必须手动用`super(variable);`方法调用父类构造器。**

```java
package com.n1etzsch3.extendsconstructor;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Father{
    public Father(int num){
        System.out.println("Father's Parameterized constructor is being called");
    }
}

class Son extends Father{
    public Son(){
      //调用父类有参构造器。
        super(10);
        System.out.println("Son's Parameterless constructor is being called");
    }
}

```

> **默认子类全部构造器第一行代码都是`super();`，如果父类没有无参构造器，则我们必须在子类构造器的第一行手写`super(variable);`指定调用父类有参构造器。**



### 应用场景

**在利用有参构造器初始化对象属性的时候，可以把子类继承自父类的这部分属性也完成初始化。**

例如：

**父类**

```java
package com.n1etzsch3.extendsconstructor;

public class People {

    private String name;
    private int age;
    private String gender;

    public People() {}

    public People(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}

```

**子类**

```java
package com.n1etzsch3.extendsconstructor;

public class Teacher extends People {
    private String skills;
  
  	public Teacher(){}
    
    public Teacher(String name, int age, String gender, String skills) {
      // 用super(...);手动调用父类构造器，传递参数。
        super(name, age, gender);
        setSkills(skills);
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}

```



### `this()`关键字调用兄弟构造器

​	可以用`this(...)`关键字来调用兄弟构造器（即构造器的重写方法），来减少代码。

```java
// 例如要录入人员信息，但是属性skills和school是固定的，用户只需输入name, age, gender就行。
package com.n1etzsch3.extendsconstructor;

public class Teacher extends People {
    private String skills;
    private String school;

    public Teacher(){}

    public Teacher(String name, int age, String gender) {
      // 通过this来实现兄弟构造器的调用，传递参数。
        this(name, age, gender, "Java", "QingHua University");
    }

    public Teacher(String name, int age, String gender, String skills, String school) {
        super(name, age, gender);
        setSkills(skills);
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}

```

> **注意！`super(...)` 和 `this(...)` 必须写在构造器第一行，且不能同时出现。（因为两者都必须在第一行）**









