package com.example.skyprohomeworkmockito.controller;

import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.DepartmentService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable int id) {
        return departmentService.getEmployeesByDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSumSalaryByDepartment(@PathVariable int id) {
        return departmentService.getSumSalaryByDepartment(id);
    }

    @GetMapping("{id}/salary/max")
    public int getMaxSalaryByDepartment(@PathParam("id") int departmentId) {
        return departmentService.getMaxSalaryByDepartment(departmentId);
    }


    @GetMapping("{id}/salary/min")
    public int getMinSalaryByDepartment(@PathParam("id") int departmentId) {
        return departmentService.getMinSalaryByDepartment(departmentId);
    }

    @GetMapping("employees")
    public Map<Integer, List<Employee>> getEmployeesGroupByDepartments() {
        return departmentService.getEmployeesGroupByDepartments();
    }




}
