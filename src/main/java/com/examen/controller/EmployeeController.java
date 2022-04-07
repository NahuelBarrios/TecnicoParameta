package com.examen.controller;

import com.examen.dto.EmployeeCreationDto;
import com.examen.dto.EmployeeDto;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface EmployeeController {

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeDto createEmployee(@Valid @RequestBody EmployeeCreationDto employeeCreationDto);
}
