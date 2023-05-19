package com.example.skyprohomeworkmockito.handler;

import com.example.skyprohomeworkmockito.exception.DepartmentIllegalArgumentException;
import com.example.skyprohomeworkmockito.exception.DepartmentNotFoundException;
import com.example.skyprohomeworkmockito.exception.EmployeesMapIsEmptyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class DepartmentExceptionHandler {

    @ExceptionHandler(DepartmentIllegalArgumentException.class)
    public String handlerNoParameterIdInHttpRequestException() {
        return "В запросе отсутствует параметр id";
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public String handlerNoEmployeesInDepartmentException() {
        return "В отделе нет сотрудников";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handlerSalaryMaxAndMinNoEmployeesInDepartmentException() {
        return "В отделе нет сотрудников";
    }

    @ExceptionHandler(EmployeesMapIsEmptyException.class)
    public String handlerMapWithEmployeesIsEmptyException() {
        return "В базе нет ни одного работника";
    }
}
