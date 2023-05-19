package com.example.skyprohomeworkmockito.constant;

import com.example.skyprohomeworkmockito.model.Employee;

import java.util.Map;

public class EmployeeConstant {

    public static final Employee EMPLOYEE_1 =
            new Employee("Иван", "Иванович", "Иванов", 25000, 1);

    public static final Employee EMPLOYEE_2 =
            new Employee("Петр", "Петрович", "Петров", 31000, 1);

    public static final Employee EMPLOYEE_3 =
            new Employee("Николай", "Николаевич", "Николаев", 29000, 2);


    public static final Map<Integer, Employee> EMPLOYEE_MAP = Map.of(
            EMPLOYEE_1.getId(), EMPLOYEE_1,
            EMPLOYEE_2.getId(), EMPLOYEE_2,
            EMPLOYEE_3.getId(), EMPLOYEE_3
    );
}
