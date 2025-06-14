# Java-GUI



## Java的GUI编程包

+ AWT(Abstract Window Toolkit)
  + 提供了一组原生的GUI组建，依赖于**操作系统**的本地窗口系统。**<font color=red>几乎没有可移植性。</font>**

+ Swing
  + 基于AWT，提供更丰富的GUI组件，轻量级组件，**不依赖于本地窗口系统！**



## Swing

### 常用的Swing组件

+ JFrame：窗口。
+ JPanel：画布，用于组织其他组件容器。
+ JButton： 按钮组件。
+ JTextField： 输入框。
+ JTable： 表格。

### 常用操作

```java
package com.n1etzsch3.GUIdemo;

import javax.swing.*;

public class Demo {
    public static void main(String[] args) {
        // 创建一个窗口
        JFrame win = new JFrame("Demo Window");
        // 设置窗口大小
        win.setSize(400, 300);
        // 设置窗口初始位置
        win.setLocationRelativeTo(null);  // 居中显示窗口

        // 创建桌布
        JPanel panel = new JPanel();
        // 设置桌布背景颜色
        panel.setBackground(java.awt.Color.LIGHT_GRAY);
        // 将桌布添加到窗口
        win.add(panel);

        // 设置一个按钮
        JButton button = new JButton("Click Me!");
        // 添加按钮到桌布
        panel.add(button);
        // 设置按钮位置
        button.setBounds(150, 100, 100, 30);  // 设置按钮位置和大小
        // 设置按钮点击事件
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(win, "Button was clicked!");  // 弹出对话框
        });

        // 设置窗口关闭操作
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 关闭窗口时退出程序

        // 设置窗口可见
        win.setVisible(true);
    }
}

```

### Swing 常用布局管理器详解

布局管理器是 Swing 的核心机制，负责控制组件在容器中的位置和大小。以下是 7 种最常用的布局管理器及其详细用法：

------

#### 1. **BorderLayout（边界布局）**

- **特点**：将容器分为 5 个区域（北、南、东、西、中）

- **适用场景**：主框架布局、顶部工具栏+底部状态栏+中间内容区

- **使用技巧：**

  ```java
  JFrame frame = new JFrame();
  frame.setLayout(new BorderLayout());
  
  frame.add(new JButton("北"), BorderLayout.NORTH); // 顶部
  frame.add(new JButton("南"), BorderLayout.SOUTH); // 底部
  frame.add(new JButton("中"), BorderLayout.CENTER); // 占据剩余空间
  ```

- **注意事项：**

  - 未指定位置时默认添加到 CENTER
  - 同一区域添加多个组件时只显示最后一个
  - 北/南区域高度固定，东/西区域宽度固定

------

#### 2. **FlowLayout（流式布局）**

- **特点**：按添加顺序水平排列，空间不足时自动换行

- **适用场景**：工具栏、按钮组、简单表单

- **对齐方式：**

  ```java
  // 左对齐（默认）
  panel.setLayout(new FlowLayout(FlowLayout.LEFT)); 
  
  // 居中对齐
  panel.setLayout(new FlowLayout(FlowLayout.CENTER));
  
  // 右对齐
  panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
  ```

- **高级设置：**

  ```java
  // 设置水平和垂直间距
  new FlowLayout(FlowLayout.LEFT, 10, 20); // hgap=10, vgap=20
  ```

------

#### 3. **GridLayout（网格布局）**

- **特点**：严格的行列网格，所有单元格大小相同

- **适用场景**：计算器界面、棋盘类布局

- **基本用法：**

  ```java
  // 创建3行2列的网格
  panel.setLayout(new GridLayout(3, 2)); 
  
  panel.add(new JButton("1"));
  panel.add(new JButton("2"));
  // ... 共添加6个组件
  ```

- **间隙控制：**

  ```java
  // 设置水平和垂直间距
  new GridLayout(2, 3, 5, 10); // hgap=5, vgap=10
  ```

- **动态扩展：**

  ```java
  // 优先扩展行（0表示不限制）
  new GridLayout(0, 4); // 固定4列，行数自动扩展
  ```

------

#### 4. **BoxLayout（盒式布局）**

- **特点**：单行/列排列，支持组件对齐和间距控制

- **适用场景**：垂直工具栏、复杂嵌套布局

- **创建方式：**

  ```java
  // 垂直排列
  JPanel vertPanel = new JPanel();
  vertPanel.setLayout(new BoxLayout(vertPanel, BoxLayout.Y_AXIS));
  
  // 水平排列
  JPanel horzPanel = new JPanel();
  horzPanel.setLayout(new BoxLayout(horzPanel, BoxLayout.X_AXIS));
  ```

- **间距控制：**

  ```java
  // 添加固定间距
  vertPanel.add(Box.createRigidArea(new Dimension(0, 10)));
  
  // 添加弹性空间（撑开组件）
  vertPanel.add(Box.createVerticalGlue());
  ```

- **对齐控制：**

  ```java
  button.setAlignmentX(Component.CENTER_ALIGNMENT); // 水平居中
  ```

------

#### 5. **GridBagLayout（网格包布局）**

- **特点**：最灵活的布局管理器，支持复杂界面

- **适用场景**：企业级表单、参数设置面板

- **使用步骤：**

  ```java
  JPanel panel = new JPanel(new GridBagLayout());
  GridBagConstraints gbc = new GridBagConstraints();
  
  // 示例：添加标签
  gbc.gridx = 0; // 列 0
  gbc.gridy = 0; // 行 0
  gbc.insets = new Insets(5, 5, 5, 5); // 边距
  panel.add(new JLabel("用户名:"), gbc);
  
  // 示例：添加文本框
  gbc.gridx = 1;
  gbc.fill = GridBagConstraints.HORIZONTAL; // 水平填充
  gbc.weightx = 1.0; // 分配额外空间
  panel.add(new JTextField(20), gbc);
  ```

- **核心参数：**

  - `gridx/gridy`：单元格坐标
  - `gridwidth/gridheight`：组件占用的单元格数
  - `weightx/weighty`：空间分配权重（0-1）
  - `anchor`：组件在单元格内的对齐方式
  - `fill`：填充方式（NONE, HORIZONTAL, VERTICAL, BOTH）

------

#### 6. **CardLayout（卡片布局）**

- **特点**：多卡片叠放，每次只显示一张

- **适用场景**：向导界面、选项卡切换

- **基本用法：**

  ```java
  JPanel cards = new JPanel(new CardLayout());
  
  // 添加卡片
  cards.add(new JPanel(), "登录页");
  cards.add(new JPanel(), "主界面");
  
  // 切换卡片
  CardLayout cl = (CardLayout)cards.getLayout();
  cl.show(cards, "主界面"); // 显示指定卡片
  ```

- **导航控制：**

  ```java
  cl.first(cards);  // 第一张
  cl.last(cards);   // 最后一张
  cl.next(cards);   // 下一张
  cl.previous(cards);// 上一张
  ```

------

#### 7. **GroupLayout（分组布局）**

- **特点**：官方推荐布局，支持水平和垂直双维度控制

- **适用场景**：IDE自动生成的布局、精确对齐需求

- **基本结构：**

  ```java
  JPanel panel = new JPanel();
  GroupLayout layout = new GroupLayout(panel);
  panel.setLayout(layout);
  
  // 创建水平组（控制X轴）
  GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
  
  // 创建垂直组（控制Y轴）
  GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
  ```

- **典型用法：**

  ```java
  // 水平组：标签 + 间隔 + 文本框
  hGroup.addComponent(label)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(textField);
  
  // 垂直组：对齐基线
  vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                   .addComponent(label)
                   .addComponent(textField));
  
  layout.setHorizontalGroup(hGroup);
  layout.setVerticalGroup(vGroup);
  ```

------

### 布局管理器组合技巧

1. **嵌套布局**：

   ```java
   JPanel main = new JPanel(new BorderLayout());
   JPanel top = new JPanel(new FlowLayout()); // 顶部工具栏
   JPanel center = new JPanel(new GridLayout(2, 2)); // 中心网格
   
   main.add(top, BorderLayout.NORTH);
   main.add(center, BorderLayout.CENTER);
   ```

2. **空布局（绝对定位）**：

   ```java
   panel.setLayout(null); // 禁用布局管理器
   button.setBounds(50, 30, 100, 40); // 手动设置位置和大小
   ```

   > 慎用：破坏跨平台适配性

3. **布局选择指南**：

   - 简单界面：`FlowLayout` 或 `BoxLayout`
   - 表单布局：`GridBagLayout` 或 `GroupLayout`
   - 主框架：`BorderLayout` + 嵌套面板
   - 等分区域：`GridLayout`
   - 向导界面：`CardLayout`



## 事件处理

在GUI编程中，事件的处理是通过事件监听器(Event Listener)完成的。

### 常用的事件监听器：

#### 1、点击事件监听器`ActionListener`

#### 2、按键事件监听器`KeyListener`

#### 3、鼠标行为监听器`MouseListener`



### 事件的常用写法：

#### 1、使用匿名内部类：

```java
button.addActionListener(e -> {
    JOptionPane.showMessageDialog(win, "Button was clicked!");
});

```



#### 2、自定义窗口

​	**通过自定义窗口，让窗口对象实现事件接口。最合适的写法。为每一个窗口自定义一个类。**

```java
package com.n1etzsch3.GUIdemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 继承JFrame这个大类，实现监听器接口。
public class LoginFrame extends JFrame implements ActionListener {
    public LoginFrame(){
        // 设置窗口标题
        this.setTitle("Login Frame");
        // 设置窗口大小
        this.setSize(400, 300);
        // 设置窗口关闭时的操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口位置为屏幕中心
        this.setLocationRelativeTo(null);

        init();
    }

    private void init() {
        // 初始化组件或其他设置
        // 设置布局管理器
        this.setLayout(new java.awt.FlowLayout());

        // 添加一个面板
        JPanel jp = new JPanel();
        this.add(jp);

        // 添加一个按钮
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        jp.add(loginButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Login button clicked!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}

```

```java
package com.n1etzsch3.GUIdemo;

public class Demo3 {
    public static void main(String[] args) {
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
    }
}

```

> **注意！setVisible要写在所有代码之后，不然可能导致组件无法渲染出来。**