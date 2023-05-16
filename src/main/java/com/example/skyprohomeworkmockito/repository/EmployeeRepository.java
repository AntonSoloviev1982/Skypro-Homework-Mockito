package com.example.skyprohomeworkmockito.repository;

import com.example.skyprohomeworkmockito.model.Employee;

import java.util.Map;

public interface EmployeeRepository {

    public Map<String, Employee> getEmployees();

    public Employee addNewEmployee(Employee employee);

    public Employee removeEmployee(Employee employee);

    public Employee findEmployee(Employee employee);
}
