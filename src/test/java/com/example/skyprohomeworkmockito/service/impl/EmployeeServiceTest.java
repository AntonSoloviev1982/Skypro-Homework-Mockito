package com.example.skyprohomeworkmockito.service.impl;

import com.example.skyprohomeworkmockito.exception.EmployeeAlreadyAddedException;
import com.example.skyprohomeworkmockito.model.Employee;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.junit.jupiter.api.Test;

import static com.example.skyprohomeworkmockito.constant.EmployeeConstant.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeServiceImpl();

    @Test
    public void shouldReturnEmployeeInMethodAddNewEmployeeWhenEmployeeNoAlreadyAdded() {
        Employee actual = out.addNewEmployee(EMPLOYEE_1);
        assertEquals(EMPLOYEE_1, actual);
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionInMethodAddNewEmployeeWhenEmployeeAlreadyAdded() {

        when(out.addNewEmployee(EMPLOYEE_1)).thenThrow(EmployeeAlreadyAddedException.class);
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.addNewEmployee(EMPLOYEE_1));
    }

    @Test
    public void shouldReturnEmployeeInMethodRemoveEmployeeWhenEmployeeIsFound() {
        Employee actual = out.removeEmployee(EMPLOYEE_1);
        assertEquals(EMPLOYEE_1, actual);
    }

    @Test
    public void shouldReturnEmployeeNotFoundExceptionInMethodRemoveEmployeeWhenEmployeeIsNotFound() {
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.removeEmployee(EMPLOYEE_1));
    }


}
