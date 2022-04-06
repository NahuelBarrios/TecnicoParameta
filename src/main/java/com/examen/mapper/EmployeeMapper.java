package com.examen.mapper;

import com.examen.domain.Employee;
import com.examen.dto.EmployeeCreationDto;
import com.examen.repository.models.EmployeeModel;

public class EmployeeMapper {

    public static EmployeeModel mapDomainToModel(Employee employee){
        EmployeeModel employeeModel = EmployeeModel.builder()
                .id(employee.getId())
                .names(employee.getNames())
                .lastNames(employee.getLastNames())
                .typeDocument(employee.getTypeDocument())
                .numberDocument(employee.getNumberDocument())
                .birthDate(employee.getBirthDate())
                .startDate(employee.getStartDate())
                .post(employee.getPost())
                .salary(employee.getSalary()).build();
        return employeeModel;
    }

    public static Employee mapModelToDomain(EmployeeModel employeeModel){
        Employee employee = Employee.builder()
                .id(employeeModel.getId())
                .names(employeeModel.getNames())
                .lastNames(employeeModel.getLastNames())
                .typeDocument(employeeModel.getTypeDocument())
                .numberDocument(employeeModel.getNumberDocument())
                .birthDate(employeeModel.getBirthDate())
                .startDate(employeeModel.getStartDate())
                .post(employeeModel.getPost())
                .salary(employeeModel.getSalary()).build();
        return employee;
    }

    public static Employee mapCreationToDomain(EmployeeCreationDto employeeCreationDto){
        Employee employee = Employee.builder()
                .names(employeeCreationDto.getNames())
                .lastNames(employeeCreationDto.getLastNames())
                .typeDocument(employeeCreationDto.getTypeDocument())
                .numberDocument(employeeCreationDto.getNumberDocument())
                .birthDate(employeeCreationDto.getBirthDate())
                .startDate(employeeCreationDto.getStartDate())
                .post(employeeCreationDto.getPost())
                .salary(employeeCreationDto.getSalary()).build();
        return employee;
    }

}
