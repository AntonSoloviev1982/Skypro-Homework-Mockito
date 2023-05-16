package com.example.skyprohomeworkmockito.service.impl;


import com.example.skyprohomeworkmockito.exception.EmployeeAlreadyAddedException;
import com.example.skyprohomeworkmockito.exception.EmployeeNotFoundException;
import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Map<String, Employee> getEmployees() {
        return Collections.unmodifiableMap(employees);
    }

    @Override
    public Employee addNewEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        if (!employees.containsKey(employee.getFullName(employee))) {
            employees.put(employee.getFullName(employee), employee);
        } else {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        if (employees.containsKey(employee.getFullName(employee))) {
            employees.remove(employee.getFullName(employee));
        } else {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        if (!employees.containsKey(employee.getFullName(employee))) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employee;
    }

//    public Map<String, Employee> getAllEmployees() {
//        return Collections.unmodifiableMap(employees);
//    }



}
