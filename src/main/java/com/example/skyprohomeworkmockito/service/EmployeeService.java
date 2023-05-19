package com.example.skyprohomeworkmockito.service;

import com.example.skyprohomeworkmockito.model.Employee;

import java.util.Map;

public interface EmployeeService {

    public Map<Integer, Employee> getEmployees();

    public Employee addNewEmployee(Employee employee);

    public Employee removeEmployee(Employee employee);

    public Employee findEmployee(Employee employee);
}
