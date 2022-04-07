package com.examen.controller.impl;

import com.examen.controller.EmployeeController;
import com.examen.domain.Employee;
import com.examen.dto.EmployeeCreationDto;
import com.examen.dto.EmployeeDto;
import com.examen.exception.EmployeeNotFoundException;
import com.examen.mapper.EmployeeMapper;
import com.examen.service.EmployeeService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResource implements EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeCreationDto employeeCreationDto){
            Employee employee = EmployeeMapper.mapCreationToDomain(employeeCreationDto);
            EmployeeDto employeeInformation = EmployeeMapper.mapDomainToInformation(employee);
            employeeService.createEmployee(employee);
            return employeeInformation;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
