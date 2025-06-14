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
