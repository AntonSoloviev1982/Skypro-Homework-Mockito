package com.example.skyprohomeworkmockito.constant;

import static com.example.skyprohomeworkmockito.constant.EmployeeConstant.*;
import com.example.skyprohomeworkmockito.model.Employee;

import java.util.List;
import java.util.Map;

public class DepartmentConstant {

    public static final List<Employee> EMPLOYEES_BY_DEPARTMENT = List.of(EMPLOYEE_1, EMPLOYEE_2);

    public static final int ID_DEPARTMENT = 1;

    public static final int ILLEGAL_ARGUMENT_ID_DEPARTMENT = 0;

    public static final int NO_SUCH_ID_DEPARTMENT = 5;

    public static final int SUM_SALARY_BY_DEPARTMENT = 56000;

    public static final int MAX_SALARY_BY_DEPARTMENT = 31000;

    public static final int MIN_SALARY_BY_DEPARTMENT = 25000;

    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENTS_MAP = Map.of(
            1, List.of(EMPLOYEE_1, EMPLOYEE_2),
            2, List.of(EMPLOYEE_3)
    );
}
