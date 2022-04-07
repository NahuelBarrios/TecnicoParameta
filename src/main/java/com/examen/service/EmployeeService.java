package com.examen.service;

import com.examen.domain.Employee;
import com.examen.exception.EmployeeNotFoundException;
import com.examen.mapper.EmployeeMapper;
import com.examen.repository.EmployeeRepository;
import com.examen.repository.models.EmployeeModel;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee createEmployee(Employee employee) throws EmployeeNotFoundException{
        Date today = new Date();
            if((today.getYear() - employee.getBirthDate().getYear()) >=18){
                EmployeeModel employeeModel = employeeRepository.save(EmployeeMapper.mapDomainToModel(employee));
                return EmployeeMapper.mapModelToDomain(employeeModel);
            }else {
                throw new EmployeeNotFoundException(String.format("es menor de edad"));
            }
    }

}
