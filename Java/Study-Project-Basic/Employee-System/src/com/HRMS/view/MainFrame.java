package com.HRMS.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("人事管理系统");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245));

        // 标题面板
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(70, 130, 180));
        titlePanel.setBorder(new EmptyBorder(20, 0, 20, 0));
        JLabel titleLabel = new JLabel("人事管理系统");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 30, 0));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(new EmptyBorder(50, 50, 50, 50));

        // 用户按钮
        JButton userBtn = createStyledButton("我是用户", new Color(70, 130, 180), Color.BLACK);
        userBtn.addActionListener(e -> {
            new LoginFrame(false);  // 监听到点击事件之后，就渲染出 LoginFrame 窗口
            dispose();  // 然后关闭当前窗口
        });

        // 管理员按钮
        JButton adminBtn = createStyledButton("我是管理员", new Color(50, 120, 160), Color.BLACK);
        adminBtn.addActionListener(e -> {
            new LoginFrame(true);
            dispose();
        });

        buttonPanel.add(userBtn);
        buttonPanel.add(adminBtn);

        // 底部信息
        JLabel footerLabel = new JLabel("© 2025 HRMS - 人事管理系统V1.0");
        footerLabel.setFont(new Font("宋体", Font.PLAIN, 12));
        footerLabel.setForeground(Color.GRAY);
        footerLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 添加组件
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(footerLabel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JButton createStyledButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("微软雅黑", Font.BOLD, 18));
        button.setBackground(bgColor);
        button.setForeground(fgColor); // 设置按钮文字颜色
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(15, 0, 15, 0));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }
}

