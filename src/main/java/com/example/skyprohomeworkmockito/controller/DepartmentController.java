package com.example.skyprohomeworkmockito.controller;

import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.DepartmentService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathParam("id") int departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

//    @GetMapping("max-salary")
//    public Employee getEmployeeWithMaxSalaryFromDepartment(@RequestParam("departmentId") int departmentId) {
//        return departmentService.getEmployeeWithMaxSalaryFromDepartment(departmentId);
//    }
//
//    @GetMapping("min-salary")
//    public Employee getEmployeeWithMinSalaryFromDepartment(@RequestParam("departmentId") int departmentId) {
//        return serviceByDepartment.getEmployeeWithMinSalaryFromDepartment(departmentId);
//    }
//
//
//    @GetMapping("all-by-departments")
//    public Map<Integer, List<Employee>> getAllEmployeesByAllDepartment() {
//        return serviceByDepartment.getAllEmployeesByAllDepartment();
//    }


}
