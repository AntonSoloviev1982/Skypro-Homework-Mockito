package com.example.skyprohomeworkmockito.service.impl;


import com.example.skyprohomeworkmockito.exception.EmployeeAlreadyAddedException;
import com.example.skyprohomeworkmockito.exception.EmployeeNotFoundException;
import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.repository.EmployeeRepository;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.springframework.stereotype.Service;


import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return repository.getEmployees();
    }

    @Override
    public Employee addNewEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        if (repository.getEmployees().containsKey(employee.getFullName(employee))) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        }
        return repository.addNewEmployee(employee);
    }

    @Override
    public Employee removeEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        if (!repository.getEmployees().containsKey(employee.getFullName(employee))) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return repository.removeEmployee(employee);
    }

    @Override
    public Employee findEmployee(String name, String patronymic, String surname, int salary, int department) {
        Employee employee = new Employee(name, patronymic, surname, salary, department);
        if (!repository.getEmployees().containsKey(employee.getFullName(employee))) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return repository.findEmployee(employee);
    }



}
