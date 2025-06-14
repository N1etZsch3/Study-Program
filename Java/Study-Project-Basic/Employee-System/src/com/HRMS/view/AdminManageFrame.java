package com.HRMS.view;

import com.HRMS.model.Employee;
import com.HRMS.controller.EmployeeService;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminManageFrame extends JFrame {
    private JTable employeeTable;
    private DefaultTableModel model;

    public AdminManageFrame() {
        setTitle("员工信息管理");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(245, 245, 245));

        // 标题面板
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(70, 130, 180));
        titlePanel.setBorder(new EmptyBorder(10, 20, 10, 0));

        // 标题标签
        JLabel titleLabel = new JLabel("员工信息管理");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel, BorderLayout.WEST);

        // 添加搜索面板
        titlePanel.add(createSearchPanel(), BorderLayout.EAST);

        // 加载员工数据
        refreshEmployeeTable();

        // 表格设置
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200)),
                new EmptyBorder(10, 10, 10, 10)
        ));

        // 按钮面板
        JPanel buttonPanel = createButtonPanel();

        // 添加组件
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        searchPanel.setBackground(new Color(70, 130, 180));
        searchPanel.setBorder(new EmptyBorder(0, 0, 0, 10));

        // 搜索文本框
        JTextField searchField = new JTextField(15);
        searchField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        searchField.setBorder(new CompoundBorder(
                new LineBorder(new Color(200, 200, 200)),
                new EmptyBorder(5, 10, 5, 10)
        ));
        searchField.setToolTipText("输入员工姓名、部门或ID进行搜索");
        searchField.addActionListener(e -> searchEmployees(searchField.getText()));

        // 搜索按钮
        JButton searchBtn = new JButton("搜索");
        styleButton(searchBtn, new Color(100, 180, 100));
        searchBtn.addActionListener(e -> searchEmployees(searchField.getText()));

        // 添加组件
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        return searchPanel;
    }

    private void searchEmployees(String keyword) {
        String searchTerm = keyword.trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            refreshEmployeeTable();
            return;
        }

        List<Employee> allEmployees = EmployeeService.getAllEmployees();
        List<Employee> filteredEmployees = allEmployees.stream()
                .filter(emp ->
                        String.valueOf(emp.getId()).contains(searchTerm) ||
                                emp.getName().toLowerCase().contains(searchTerm) ||
                                emp.getDepartment().toLowerCase().contains(searchTerm))
                .toList();

        updateEmployeeTable(filteredEmployees);
    }

    private void refreshEmployeeTable() {
        List<Employee> employees = EmployeeService.getAllEmployees();
        updateEmployeeTable(employees);
    }

    private void updateEmployeeTable(List<Employee> employees) {
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

        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 表格单元格不可直接编辑
            }
        };

        if (employeeTable == null) {
            employeeTable = new JTable(model);
            employeeTable.setRowHeight(30);
            employeeTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));
            employeeTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
            employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            employeeTable.setGridColor(new Color(220, 220, 220));
            employeeTable.setShowGrid(true);
        } else {
            employeeTable.setModel(model);
        }
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        // 添加按钮
        JButton addBtn = new JButton("添加员工");
        styleButton(addBtn, new Color(100, 180, 100));
        addBtn.addActionListener(e -> showEmployeeDialog(null));

        // 编辑按钮
        JButton editBtn = new JButton("编辑员工");
        styleButton(editBtn, new Color(70, 130, 180));
        editBtn.addActionListener(e -> {
            int row = employeeTable.getSelectedRow();
            if (row >= 0) {
                Employee employee = new Employee(
                        (Integer) model.getValueAt(row, 0),
                        (String) model.getValueAt(row, 1),
                        (String) model.getValueAt(row, 2),
                        (Integer) model.getValueAt(row, 3),
                        (String) model.getValueAt(row, 4),
                        (String) model.getValueAt(row, 5),
                        (String) model.getValueAt(row, 6)
                );
                showEmployeeDialog(employee);
            } else {
                JOptionPane.showMessageDialog(this, "请先选择要编辑的员工！", "提示", JOptionPane.WARNING_MESSAGE);
            }
        });

        // 删除按钮
        JButton deleteBtn = new JButton("删除员工");
        styleButton(deleteBtn, new Color(220, 100, 100));
        deleteBtn.addActionListener(e -> {
            int row = employeeTable.getSelectedRow();
            if (row >= 0) {
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "确定要删除选中的员工吗？",
                        "确认删除",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    int id = (Integer) model.getValueAt(row, 0);
                    EmployeeService.deleteEmployee(id);
                    refreshEmployeeTable();
                    JOptionPane.showMessageDialog(this, "员工删除成功！", "操作成功", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "请先选择要删除的员工！", "提示", JOptionPane.WARNING_MESSAGE);
            }
        });

        // 刷新按钮
        JButton refreshBtn = new JButton("刷新数据");
        styleButton(refreshBtn, new Color(100, 150, 200));
        refreshBtn.addActionListener(e -> refreshEmployeeTable());

        // 退出按钮
        JButton logoutBtn = new JButton("退出登录");
        styleButton(logoutBtn, new Color(180, 180, 180));
        logoutBtn.addActionListener(e -> {
            new MainFrame();
            dispose();
        });

        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(refreshBtn);
        buttonPanel.add(logoutBtn);

        return buttonPanel;
    }

    private void showEmployeeDialog(Employee employee) {
        boolean isNew = employee == null;
        JDialog dialog = new JDialog(this, isNew ? "添加新员工" : "编辑员工信息", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(this);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        // 添加表单组件
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JComboBox<String> genderField = new JComboBox<>(new String[]{"男", "女"});
        JTextField ageField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField departmentField = new JTextField();
        JTextField positionField = new JTextField();

        if (!isNew) {
            idField.setText(String.valueOf(employee.getId()));
            idField.setEditable(false);
            nameField.setText(employee.getName());
            genderField.setSelectedItem(employee.getGender());
            ageField.setText(String.valueOf(employee.getAge()));
            phoneField.setText(employee.getPhone());
            departmentField.setText(employee.getDepartment());
            positionField.setText(employee.getPosition());
        }

        // 添加标签和字段到表单
        addFormRow(formPanel, "员工ID:", idField, !isNew);
        addFormRow(formPanel, "姓名:", nameField, true);
        addFormRow(formPanel, "性别:", genderField, true);
        addFormRow(formPanel, "年龄:", ageField, true);
        addFormRow(formPanel, "电话:", phoneField, true);
        addFormRow(formPanel, "部门:", departmentField, true);
        addFormRow(formPanel, "岗位:", positionField, true);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton saveBtn = new JButton("保存");
        styleButton(saveBtn, new Color(70, 130, 180));
        saveBtn.addActionListener(e -> {
            try {
                // 表单验证
                if (nameField.getText().isEmpty() ||
                        ageField.getText().isEmpty() ||
                        phoneField.getText().isEmpty() ||
                        departmentField.getText().isEmpty() ||
                        positionField.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(this, "请填写所有必填字段！", "输入错误", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 年龄验证
                int age = Integer.parseInt(ageField.getText());
                if (age < 18 || age > 65) {
                    JOptionPane.showMessageDialog(this, "年龄必须在18-65岁之间", "输入错误", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 创建员工对象
                Employee updatedEmployee = new Employee(
                        isNew ? EmployeeService.getNextEmployeeId() : employee.getId(),
                        nameField.getText(),
                        (String) genderField.getSelectedItem(),
                        age,
                        phoneField.getText(),
                        departmentField.getText(),
                        positionField.getText()
                );

                // 保存数据
                if (isNew) {
                    EmployeeService.addEmployee(updatedEmployee);
                } else {
                    EmployeeService.updateEmployee(updatedEmployee);
                }

                // 刷新表格并关闭对话框
                refreshEmployeeTable();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "员工信息保存成功！", "操作成功", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "年龄必须为有效的数字！", "输入错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton cancelBtn = new JButton("取消");
        styleButton(cancelBtn, new Color(180, 180, 180));
        cancelBtn.addActionListener(e -> dialog.dispose());

        buttonPanel.add(saveBtn);
        buttonPanel.add(cancelBtn);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.add(mainPanel);
        dialog.setVisible(true);
    }

    private void addFormRow(JPanel panel, String label, JComponent field, boolean editable) {
        if (editable) {
            styleFormField(field);
        }

        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel.add(jLabel);
        panel.add(field);
    }

    private void styleFormField(JComponent field) {
        if (field instanceof JTextField) {
            JTextField textField = (JTextField) field;
            textField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
            textField.setBorder(new CompoundBorder(
                    new LineBorder(new Color(200, 200, 200)),
                    new EmptyBorder(5, 10, 5, 10)
            ));
        } else if (field instanceof JComboBox) {
            JComboBox<?> comboBox = (JComboBox<?>) field;
            comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
            comboBox.setBorder(new CompoundBorder(
                    new LineBorder(new Color(200, 200, 200)),
                    new EmptyBorder(5, 10, 5, 10)
            ));
        }
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setFont(new Font("微软雅黑", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(6, 15, 6, 15));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // 添加悬停效果
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
    }
}