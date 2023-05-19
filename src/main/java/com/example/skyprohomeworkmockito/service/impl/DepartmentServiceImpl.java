package com.example.skyprohomeworkmockito.service.impl;

import com.example.skyprohomeworkmockito.exception.DepartmentIllegalArgumentException;
import com.example.skyprohomeworkmockito.exception.DepartmentNotFoundException;
import com.example.skyprohomeworkmockito.exception.EmployeesMapIsEmptyException;
import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.DepartmentService;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
        if (id == 0) {
            throw new DepartmentIllegalArgumentException();
        }
        List<Employee> employeesByDepartment = employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .collect(Collectors.toList());
        if (employeesByDepartment.isEmpty()) {
            throw new DepartmentNotFoundException();
        }
        return employeesByDepartment;
    }

    @Override
    public int getSumSalaryByDepartment(int id) {
        if (id == 0) {
            throw new DepartmentIllegalArgumentException();
        }
        int sumSalaryByDepartment = employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(e -> e.getSalary())
                .sum();
        if (sumSalaryByDepartment == 0) {
            throw new DepartmentNotFoundException();
        }
        return sumSalaryByDepartment;
    }

    @Override
    public int getMaxSalaryByDepartment(int id) {
        if (id == 0) {
            throw new DepartmentIllegalArgumentException();
        }
        int maxSalaryByDepartment = employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(e -> e.getSalary())
                .max()
                .getAsInt();
        if (maxSalaryByDepartment == 0) {
            throw new NoSuchElementException();
        }
        return maxSalaryByDepartment;
    }

    @Override
    public int getMinSalaryByDepartment(int id) {
        if (id == 0) {
            throw new DepartmentIllegalArgumentException();
        }
        int minSalaryByDepartment = employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == id)
                .mapToInt(e -> e.getSalary())
                .min()
                .getAsInt();
        if (minSalaryByDepartment == 0) {
            throw new NoSuchElementException();
        }
        return minSalaryByDepartment;
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupByDepartments() {
        Map<Integer, List<Employee>> employeesGroupByDepartments = employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
        if (employeesGroupByDepartments.isEmpty()) {
            throw  new EmployeesMapIsEmptyException();
        }
        return employeesGroupByDepartments;
    }
}
