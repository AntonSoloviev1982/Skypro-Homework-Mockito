package com.example.skyprohomeworkmockito.service.impl;

import com.example.skyprohomeworkmockito.exception.EmployeeAlreadyAddedException;
import com.example.skyprohomeworkmockito.exception.EmployeeNotFoundException;
import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.example.skyprohomeworkmockito.constant.EmployeeConstant.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeServiceImpl();


    @Test
    public void addNewEmployeeTest() {
        Employee actual = out.addNewEmployee(EMPLOYEE_1);
        assertEquals(EMPLOYEE_1, actual);
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.addNewEmployee(EMPLOYEE_1));
    }


    @Test
    public void removeEmployeeTest() {
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(EMPLOYEE_1));
        out.addNewEmployee(EMPLOYEE_1);
        Employee actual = out.removeEmployee(EMPLOYEE_1);
        assertEquals(EMPLOYEE_1, actual);

    }

    @Test
    public void findEmployeeTest() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(EMPLOYEE_1));
        out.addNewEmployee(EMPLOYEE_1);
        Employee actual = out.findEmployee(EMPLOYEE_1);
        assertEquals(EMPLOYEE_1, actual);
    }

    @Test
    public void getEmployeesTest() {
        out.addNewEmployee(EMPLOYEE_1);
        out.addNewEmployee(EMPLOYEE_2);
        out.addNewEmployee(EMPLOYEE_3);
        Map<Integer, Employee> expected = out.getEmployees();

        Map<Integer, Employee> actual = new HashMap<>();
        actual.put(EMPLOYEE_1.getId(), EMPLOYEE_1);
        actual.put(EMPLOYEE_2.getId(), EMPLOYEE_2);
        actual.put(EMPLOYEE_3.getId(), EMPLOYEE_3);

        assertEquals(expected, actual);

    }



}
