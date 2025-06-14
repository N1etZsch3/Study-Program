package com.n1etzsch3.GUIdemo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
