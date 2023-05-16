package com.example.skyprohomeworkmockito.service;

import com.example.skyprohomeworkmockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    public List<Employee> getEmployeesByDepartment(int departmentId);

    public int getSumSalaryByDepartment(int departmentId);

    public int getMaxSalaryByDepartment(int departmentId);

    public int getMinSalaryByDepartment(int departmentId);

    public Map<Integer, List<Employee>> getEmployeesGroupByDepartments();

}
