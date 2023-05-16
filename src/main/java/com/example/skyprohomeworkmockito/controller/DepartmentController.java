package com.example.skyprohomeworkmockito.controller;

import com.example.skyprohomework2_7.model.Employee;
import com.example.skyprohomework2_7.service.EmployeeServiceByDepartment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee/departments")
public class DepartmentController {

    private final EmployeeServiceByDepartment serviceByDepartment;

    public DepartmentController(EmployeeServiceByDepartment serviceByDepartment) {
        this.serviceByDepartment = serviceByDepartment;
    }

    @GetMapping("max-salary")
    public Employee getEmployeeWithMaxSalaryFromDepartment(@RequestParam("departmentId") int departmentId) {
        return serviceByDepartment.getEmployeeWithMaxSalaryFromDepartment(departmentId);
    }

    @GetMapping("min-salary")
    public Employee getEmployeeWithMinSalaryFromDepartment(@RequestParam("departmentId") int departmentId) {
        return serviceByDepartment.getEmployeeWithMinSalaryFromDepartment(departmentId);
    }

    @GetMapping("all")
    public List<Employee> getAllEmployeesByDepartment(@RequestParam("departmentId") int departmentId) {
        return serviceByDepartment.getAllEmployeesByDepartment(departmentId);
    }

    @GetMapping("all-by-departments")
    public Map<Integer, List<Employee>> getAllEmployeesByAllDepartment() {
        return serviceByDepartment.getAllEmployeesByAllDepartment();
    }


}
