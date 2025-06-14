package com.HRMS.controller;

import com.HRMS.model.Employee;
import com.HRMS.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String USER_FILE = "users.csv";
    private static final String EMPLOYEE_FILE = "employees.csv";

    public static void initializeFiles() {
        // 检查用户文件是否存在，如果不存在则创建默认管理员
        File userFile = new File(USER_FILE);
        if (!userFile.exists()) {
            try (PrintWriter writer = new PrintWriter(userFile)) {
                writer.println("username,password_hash,is_admin");
                // 添加默认管理员: admin/admin
                String defaultAdminPass = AuthService.md5("admin");
                writer.println("admin," + defaultAdminPass + ",true");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // 检查员工文件是否存在
        File employeeFile = new File(EMPLOYEE_FILE);
        if (!employeeFile.exists()) {
            try (PrintWriter writer = new PrintWriter(employeeFile)) {
                writer.println("id,name,gender,age,phone,department,position");
                // 添加一些示例员工
                writer.println("1,张三,男,30,13800138000,技术部,Java工程师");
                writer.println("2,李四,女,28,13900139000,市场部,营销经理");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(USER_FILE);
        if (!file.exists()) return users;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // 跳过标题行
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    users.add(new User(
                            values[0],
                            values[1],
                            Boolean.parseBoolean(values[2])
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void saveUsers(List<User> users) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE))) {
            writer.println("username,password_hash,is_admin");
            for (User user : users) {
                writer.println(user.getUsername() + "," + user.getPassword() + "," + user.isAdmin());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        File file = new File(EMPLOYEE_FILE);
        if (!file.exists()) return employees;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // 跳过标题行
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 7) {
                    employees.add(new Employee(
                            Integer.parseInt(values[0]),
                            values[1],
                            values[2],
                            Integer.parseInt(values[3]),
                            values[4],
                            values[5],
                            values[6]
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void saveEmployees(List<Employee> employees) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(EMPLOYEE_FILE))) {
            writer.println("id,name,gender,age,phone,department,position");
            for (Employee emp : employees) {
                writer.println(emp.getId() + "," +
                        emp.getName() + "," +
                        emp.getGender() + "," +
                        emp.getAge() + "," +
                        emp.getPhone() + "," +
                        emp.getDepartment() + "," +
                        emp.getPosition());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getNextEmployeeId() {
        List<Employee> employees = readEmployees();
        if (employees.isEmpty()) return 1;
        int maxId = employees.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(0);
        return maxId + 1;
    }
}

