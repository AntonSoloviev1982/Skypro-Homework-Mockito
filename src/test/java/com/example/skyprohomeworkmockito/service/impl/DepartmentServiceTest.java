package com.example.skyprohomeworkmockito.service.impl;

import com.example.skyprohomeworkmockito.exception.DepartmentIllegalArgumentException;
import com.example.skyprohomeworkmockito.exception.DepartmentNotFoundException;
import com.example.skyprohomeworkmockito.exception.EmployeesMapIsEmptyException;
import com.example.skyprohomeworkmockito.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static com.example.skyprohomeworkmockito.constant.DepartmentConstant.*;
import static com.example.skyprohomeworkmockito.constant.EmployeeConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    private final EmployeeService serviceMock = mock(EmployeeService.class);

    private DepartmentServiceImpl out;

    @BeforeEach
    public void initOut() {
        out = new DepartmentServiceImpl(serviceMock);
    }

    @Test
    public void getEmployeesByDepartmentTest() {
        when(serviceMock.getEmployees()).thenReturn(EMPLOYEE_MAP);
        assertEquals(EMPLOYEES_BY_DEPARTMENT, out.getEmployeesByDepartment(ID_DEPARTMENT));

        assertThrows(DepartmentIllegalArgumentException.class,
                () -> out.getEmployeesByDepartment(ILLEGAL_ARGUMENT_ID_DEPARTMENT));
        assertThrows(DepartmentNotFoundException.class,
                () -> out.getEmployeesByDepartment(NO_SUCH_ID_DEPARTMENT));
    }

    @Test
    public void getSumSalaryByDepartmentTest() {
        when(serviceMock.getEmployees()).thenReturn(EMPLOYEE_MAP);
        assertEquals(SUM_SALARY_BY_DEPARTMENT, out.getSumSalaryByDepartment(ID_DEPARTMENT));

        assertThrows(DepartmentIllegalArgumentException.class,
                () -> out.getSumSalaryByDepartment(ILLEGAL_ARGUMENT_ID_DEPARTMENT));
        assertThrows(DepartmentNotFoundException.class,
                () -> out.getSumSalaryByDepartment(NO_SUCH_ID_DEPARTMENT));
    }

    @Test
    public void getMaxSalaryByDepartmentTest() {
        when(serviceMock.getEmployees()).thenReturn(EMPLOYEE_MAP);
        assertEquals(MAX_SALARY_BY_DEPARTMENT, out.getMaxSalaryByDepartment(ID_DEPARTMENT));

        assertThrows(DepartmentIllegalArgumentException.class,
                () -> out.getMaxSalaryByDepartment(ILLEGAL_ARGUMENT_ID_DEPARTMENT));
        assertThrows(NoSuchElementException.class,
                () -> out.getMaxSalaryByDepartment(NO_SUCH_ID_DEPARTMENT));
    }

    @Test
    public void getMinSalaryByDepartmentTest() {
        when(serviceMock.getEmployees()).thenReturn(EMPLOYEE_MAP);
        assertEquals(MIN_SALARY_BY_DEPARTMENT, out.getMinSalaryByDepartment(ID_DEPARTMENT));

        assertThrows(DepartmentIllegalArgumentException.class,
                () -> out.getMinSalaryByDepartment(ILLEGAL_ARGUMENT_ID_DEPARTMENT));
        assertThrows(NoSuchElementException.class,
                () -> out.getMinSalaryByDepartment(NO_SUCH_ID_DEPARTMENT));
    }

    @Test
    public void getEmployeesGroupByDepartmentsTest() {
        when(serviceMock.getEmployees()).thenReturn(EMPLOYEE_MAP);
        assertEquals(EMPLOYEES_BY_DEPARTMENTS_MAP, out.getEmployeesGroupByDepartments());
    }

    @Test
    public void returnEmployeesMapIsEmptyExceptionWhenEmployeeMapIsEmptyTest() {
        when(serviceMock.getEmployees()).thenReturn(EMPTY_MAP);
        assertThrows(EmployeesMapIsEmptyException.class, () -> out.getEmployeesGroupByDepartments());
    }
}
