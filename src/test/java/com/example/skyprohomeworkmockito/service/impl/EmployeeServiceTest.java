package com.example.skyprohomeworkmockito.service.impl;

import com.example.skyprohomeworkmockito.exception.EmployeeAlreadyAddedException;
import com.example.skyprohomeworkmockito.exception.EmployeeNotFoundException;
import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.junit.jupiter.api.Test;

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

    }



}
