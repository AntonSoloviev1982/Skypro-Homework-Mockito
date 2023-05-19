package com.example.skyprohomeworkmockito.handler;

import com.example.skyprohomeworkmockito.exception.DepartmentIllegalArgumentException;
import com.example.skyprohomeworkmockito.exception.DepartmentNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
