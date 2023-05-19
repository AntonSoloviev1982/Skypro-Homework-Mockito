package com.example.skyprohomeworkmockito.service;

import com.example.skyprohomeworkmockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    public List<Employee> getEmployeesByDepartment(int id);

    public int getSumSalaryByDepartment(int id);

    public int getMaxSalaryByDepartment(int id);

    public int getMinSalaryByDepartment(int id);

    public Map<Integer, List<Employee>> getEmployeesGroupByDepartments();

}
