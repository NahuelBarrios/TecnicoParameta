package com.examen.controller.impl;

import com.examen.controller.EmployeeController;
import com.examen.domain.Employee;
import com.examen.dto.EmployeeCreationDto;
import com.examen.dto.EmployeeDto;
import com.examen.mapper.EmployeeMapper;
import com.examen.service.EmployeeService;
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
}
