package com.example.skyprohomeworkmockito.service.impl;

import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.DepartmentService;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return null;
    }

    @Override
    public int getSumSalaryByDepartment(int departmentId) {
        return 0;
    }

    @Override
    public int getMaxSalaryByDepartment(int departmentId) {
        return 0;
    }

    @Override
    public int getMinSalaryByDepartment(int departmentId) {
        return 0;
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupByDepartments() {
        return null;
    }
}
