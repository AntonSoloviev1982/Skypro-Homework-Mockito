package com.example.skyprohomeworkmockito.service.impl;

import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.DepartmentService;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int id) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
    }

    @Override
    public int getSumSalaryByDepartment(int id) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(e -> e.getSalary())
                .sum();
    }

    @Override
    public int getMaxSalaryByDepartment(int id) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(e -> e.getSalary())
                .max()
                .getAsInt();
    }

    @Override
    public int getMinSalaryByDepartment(int id) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(e -> e.getSalary())
                .min()
                .getAsInt();
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupByDepartments() {
        return employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
}
