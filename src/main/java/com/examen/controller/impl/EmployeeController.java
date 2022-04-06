package com.examen.controller.impl;

import com.examen.controller.IEmployeeController;
import com.examen.domain.Employee;
import com.examen.dto.EmployeeCreationDto;
import com.examen.dto.EmployeeInformation;
import com.examen.exception.EmployeeNotFoundException;
import com.examen.mapper.EmployeeMapper;
import com.examen.service.EmployeeService;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements IEmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Override
    public EmployeeInformation employeeCreate(EmployeeCreationDto employeeCreationDto) throws EmployeeNotFoundException{
        Employee employee = EmployeeMapper.mapCreationToDomain(employeeCreationDto);
        EmployeeInformation employeeInformation = EmployeeMapper.mapDomainToInformation(employee);
        //if(employeeInformation.getAge()>=18)
        employeeService.createEmployee(employee);
       // else
         //   throw new EmployeeNotFoundException(String.format("es menor de edad"));
        return employeeInformation;
    }

}
