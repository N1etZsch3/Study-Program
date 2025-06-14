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
        btn.addActionListener(e -> System.out.println("Button clicked!"));

        // 设置窗口可见
        win.setVisible(true);
    }
}
