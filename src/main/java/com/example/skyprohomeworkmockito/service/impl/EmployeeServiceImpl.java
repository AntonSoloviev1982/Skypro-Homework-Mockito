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

    private final Map<Integer, Employee> employees = new HashMap<>();


    @Override
    public Employee addNewEmployee(Employee employee) {
        if (!employees.containsKey(employee.getId())) {
            employees.put(employee.getId(), employee);
        } else {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (employees.containsKey(employee.getId())) {
            employees.remove(employee.getId());
        } else {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employee;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (!employees.containsKey(employee.getId())) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employee;
    }

    @Override
    public Map<Integer, Employee> getEmployees() {
        return Collections.unmodifiableMap(employees);
    }



}
