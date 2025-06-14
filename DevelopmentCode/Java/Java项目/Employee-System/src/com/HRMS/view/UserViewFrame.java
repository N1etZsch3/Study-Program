package com.HRMS.view;

import com.HRMS.model.Employee;
import com.HRMS.controller.FileUtil;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.util.List;

class UserViewFrame extends JFrame {
    private JTable employeeTable;

    public UserViewFrame() {
        setTitle("员工信息查看");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(245, 245, 245));

        // 标题面板
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(70, 130, 180));
        titlePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        JLabel titleLabel = new JLabel("员工信息查看");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

        // 员工表格
        List<Employee> employees = FileUtil.readEmployees();
        String[] columnNames = {"ID", "姓名", "性别", "年龄", "电话", "部门", "岗位"};
        Object[][] data = new Object[employees.size()][columnNames.length];

        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            data[i][0] = emp.getId();
            data[i][1] = emp.getName();
            data[i][2] = emp.getGender();
            data[i][3] = emp.getAge();
            data[i][4] = emp.getPhone();
            data[i][5] = emp.getDepartment();
            data[i][6] = emp.getPosition();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 所有单元格不可编辑
            }
        };

        employeeTable = new JTable(model);
        employeeTable.setRowHeight(30);
        employeeTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));
        employeeTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeTable.setGridColor(new Color(220, 220, 220));
        employeeTable.setShowGrid(true);

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200)),
                new EmptyBorder(10, 10, 10, 10)
        ));

        // 按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        JButton logoutBtn = new JButton("退出登录");
        styleButton(logoutBtn, new Color(180, 180, 180));
        logoutBtn.addActionListener(e -> {
            new MainFrame();
            dispose();
        });
        buttonPanel.add(logoutBtn);

        // 添加组件
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
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
