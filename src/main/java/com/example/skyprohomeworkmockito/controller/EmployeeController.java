package com.example.skyprohomeworkmockito.controller;

import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addNewEmployee(@RequestParam("name") String name,
                                   @RequestParam("patronymic") String patronymic,
                                   @RequestParam("surname") String surname,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("department") int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        return employeeService.addNewEmployee(employee);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String name,
                                   @RequestParam("patronymic") String patronymic,
                                   @RequestParam("surname") String surname,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("department") int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        return employeeService.removeEmployee(employee);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name,
                                 @RequestParam("patronymic") String patronymic,
                                 @RequestParam("surname") String surname,
                                 @RequestParam("salary") int salary,
                                 @RequestParam("department") int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        return employeeService.findEmployee(employee);
    }

    @GetMapping("/getAll")
    public Map<Integer, Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

}
