package com.HRMS.controller;

import com.HRMS.model.Employee;

import java.util.List;

public class EmployeeService {

    public static List<Employee> getAllEmployees() {
        return FileUtil.readEmployees();
    }

    public static void addEmployee(Employee employee) {
        List<Employee> employees = FileUtil.readEmployees();
        employees.add(employee);
        FileUtil.saveEmployees(employees);
    }

    public static void updateEmployee(Employee updatedEmployee) {
        List<Employee> employees = FileUtil.readEmployees();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == updatedEmployee.getId()) {
                employees.set(i, updatedEmployee);
                break;
            }
        }
        FileUtil.saveEmployees(employees);
    }

    public static void deleteEmployee(int id) {
        List<Employee> employees = FileUtil.readEmployees();
        employees.removeIf(emp -> emp.getId() == id);
        FileUtil.saveEmployees(employees);
    }

    public static int getNextEmployeeId() {
        List<Employee> employees = getAllEmployees();
        if (employees.isEmpty()) return 1;

        int maxId = employees.stream()
                .mapToInt(Employee::getId)
                .max()
                .orElse(0);
        return maxId + 1;
    }
}