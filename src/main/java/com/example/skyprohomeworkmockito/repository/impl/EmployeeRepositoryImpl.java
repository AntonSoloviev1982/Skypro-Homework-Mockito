package com.example.skyprohomeworkmockito.repository.impl;

import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Map<String, Employee> getEmployees() {
        return Collections.unmodifiableMap(employees);
    }

    @Override
    public Employee addNewEmployee(Employee employee) {
        employees.put(employee.getFullName(employee), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        employees.remove(employee.getFullName(employee));
        return employee;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        employees.get(employee.getFullName(employee));
        return employee;
    }
}
