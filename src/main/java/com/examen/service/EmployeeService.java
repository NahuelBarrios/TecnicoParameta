package com.examen.service;

import com.examen.domain.Employee;
import com.examen.exception.EmployeeRequestException;
import com.examen.mapper.EmployeeMapper;
import com.examen.repository.EmployeeRepository;
import com.examen.repository.models.EmployeeModel;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public Employee createEmployee(Employee employee) throws EmployeeRequestException {
        Integer ageEmployee = this.getAge(employee.getBirthDate());
            if(ageEmployee >=18){
                EmployeeModel employeeModel = employeeRepository.save(EmployeeMapper.mapDomainToModel(employee));
                return EmployeeMapper.mapModelToDomain(employeeModel);
            }else {
                throw new EmployeeRequestException("Empleado menor de edad", "not.found", HttpStatus.NOT_FOUND);
            }
    }

    private Integer getAge(Date date){
        LocalDate today=  LocalDate.now();
        LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthDate,today);
        return Math.abs(period.getYears());
    }

}
