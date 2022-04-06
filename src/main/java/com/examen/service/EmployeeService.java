package com.examen.service;

import com.examen.domain.Employee;
import com.examen.mapper.EmployeeMapper;
import com.examen.repository.EmployeeRepository;
import com.examen.repository.models.EmployeeModel;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee createEmployee(Employee employee){
        EmployeeModel employeeModel = employeeRepository.save(EmployeeMapper.mapDomainToModel(employee));
        return EmployeeMapper.mapModelToDomain(employeeModel);
    }

}
