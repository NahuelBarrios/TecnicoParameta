package com.examen.controller.impl;

import com.examen.controller.IEmployeeController;
import com.examen.domain.Employee;
import com.examen.dto.EmployeeCreationDto;
import com.examen.mapper.EmployeeMapper;
import com.examen.service.EmployeeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements IEmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Override
    public Employee employeeCreate(EmployeeCreationDto employeeCreationDto) {
        Employee employee = EmployeeMapper.mapCreationToDomain(employeeCreationDto);
        employeeService.createEmployee(employee);
        return employee;
    }

}
