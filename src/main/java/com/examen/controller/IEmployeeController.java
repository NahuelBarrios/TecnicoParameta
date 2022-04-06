package com.examen.controller;

import com.examen.domain.Employee;
import com.examen.dto.EmployeeCreationDto;
import com.examen.dto.EmployeeInformation;
import com.examen.exception.EmployeeNotFoundException;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface IEmployeeController {

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeInformation employeeCreate(@Valid @RequestBody EmployeeCreationDto employeeCreationDto) throws EmployeeNotFoundException;
}
