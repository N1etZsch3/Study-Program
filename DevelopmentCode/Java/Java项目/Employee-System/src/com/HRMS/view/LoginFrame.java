package com.HRMS.view;

import com.HRMS.controller.AuthService;
import com.HRMS.controller.VerificationCode;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

class LoginFrame extends JFrame {
    private VerificationCode vCode;
    private final JLabel codeImageLabel;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JTextField codeField;
    private final boolean isAdmin;

    public LoginFrame(boolean isAdmin) {
        this.isAdmin = isAdmin;
        setTitle(isAdmin ? "管理员登录" : "用户登录/注册");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(new EmptyBorder(20, 30, 20, 30));

        // 标题面板
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(245, 245, 245));
        JLabel titleLabel = new JLabel(isAdmin ? "管理员登录" : "用户登录/注册");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
        titleLabel.setForeground(new Color(70, 130, 180));
        titlePanel.add(titleLabel);

        // 表单面板
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(new Color(245, 245, 245));
        formPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200), 1),
                new EmptyBorder(20, 20, 20, 20)
        ));

        // 用户名
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        usernamePanel.setBackground(new Color(245, 245, 245));
        JLabel usernameLabel = new JLabel("用户名:");
        usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernamePanel.add(usernameLabel);

        usernameField = new JTextField(20);
        styleTextField(usernameField);
        usernamePanel.add(usernameField);
        formPanel.add(usernamePanel);

        // 密码
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        passwordPanel.setBackground(new Color(245, 245, 245));
        JLabel passwordLabel = new JLabel("密 码:");
        passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordPanel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        styleTextField(passwordField);
        passwordPanel.add(passwordField);
        formPanel.add(passwordPanel);

        // 验证码
        JPanel codePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        codePanel.setBackground(new Color(245, 245, 245));
        JLabel codeLabel = new JLabel("验证码:");
        codeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        codePanel.add(codeLabel);

        // 验证码输入框
        codeField = new JTextField(8);
        styleTextField(codeField);
        codePanel.add(codeField);

        // 先初始化 codeImageLabel
        codeImageLabel = new JLabel();
        // 确保在生成验证码前已创建组件
        generateVerificationCode();

        // 光标和点击事件
        codeImageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        codeImageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generateVerificationCode();
            }
        });
        codePanel.add(codeImageLabel);

        formPanel.add(codePanel);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(245, 245, 245));

        // 登录按钮
        JButton loginBtn = new JButton("登录");
        styleButton(loginBtn, new Color(70, 130, 180));
        loginBtn.addActionListener(e -> handleLogin());
        buttonPanel.add(loginBtn);

        // 如果是用户登录界面，显示注册按钮
        if (!isAdmin) {
            JButton registerBtn = new JButton("注册");
            styleButton(registerBtn, new Color(100, 180, 100));
            registerBtn.addActionListener(e -> handleRegistration());
            buttonPanel.add(registerBtn);
        }

        // 返回按钮
        JButton backBtn = new JButton("返回");
        styleButton(backBtn, new Color(180, 180, 180));
        backBtn.addActionListener(e -> {
            new MainFrame();
            dispose();
        });
        buttonPanel.add(backBtn);

        // 添加组件
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void generateVerificationCode() {
        vCode = new VerificationCode(120, 40);
        BufferedImage image = vCode.getImage();
        // 现在可以安全访问 codeImageLabel
        codeImageLabel.setIcon(new ImageIcon(image));
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String code = codeField.getText().trim();

        // 表单验证
        if (username.isEmpty() || password.isEmpty() || code.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请填写完整信息！", "输入错误", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!vCode.validate(code)) {
            JOptionPane.showMessageDialog(this, "验证码错误，请重新输入！", "验证失败", JOptionPane.ERROR_MESSAGE);
            generateVerificationCode();
            return;
        }

        // 认证逻辑
        boolean isAuthenticated = AuthService.authenticate(username, password, isAdmin);

        if (isAuthenticated) {
            if (isAdmin) {
                new AdminManageFrame();
            } else {
                new UserViewFrame();
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "用户名或密码错误！", "登录失败", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleRegistration() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String code = codeField.getText().trim();

        if (username.isEmpty() || password.isEmpty() || code.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请填写完整信息！", "输入错误", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!vCode.validate(code)) {
            JOptionPane.showMessageDialog(this, "验证码错误，请重新输入！", "验证失败", JOptionPane.ERROR_MESSAGE);
            generateVerificationCode();
            return;
        }

        // 注册逻辑
        boolean isRegistered = AuthService.register(username, password, false);

        if (isRegistered) {
            JOptionPane.showMessageDialog(this, "注册成功！", "注册成功", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "用户名已被使用！", "注册失败", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void styleTextField(JTextField field) {
        field.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        field.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200)),
                new EmptyBorder(5, 10, 5, 10)
        ));
        field.setPreferredSize(new Dimension(200, 30));
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setFont(new Font("微软雅黑", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(8, 20, 8, 20));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
