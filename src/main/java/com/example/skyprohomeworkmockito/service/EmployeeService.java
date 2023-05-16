package com.example.skyprohomeworkmockito.service;

import com.example.skyprohomeworkmockito.model.Employee;

import java.util.Map;

public interface EmployeeService {

    public Map<String, Employee> getEmployees();

    public Employee addNewEmployee(String name, String patronymic, String surname, int salary, int department);

    public Employee removeEmployee(String name, String patronymic, String surname, int salary, int department);

    public Employee findEmployee(String name, String patronymic, String surname, int salary, int department);
}
