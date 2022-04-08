package com.examen.mapper;

import com.examen.domain.Employee;
import com.examen.dto.EmployeeCreationDto;
import com.examen.dto.EmployeeDto;
import com.examen.repository.models.EmployeeModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EmployeeMapper {

    public static EmployeeModel mapDomainToModel(Employee employee){
        EmployeeModel employeeModel = EmployeeModel.builder()
                .id(employee.getId())
                .names(employee.getNames())
                .lastNames(employee.getLastNames())
                .documentType(employee.getDocumentType())
                .documentNumber(employee.getDocumentNumber())
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
                .documentType(employeeModel.getDocumentType())
                .documentNumber(employeeModel.getDocumentNumber())
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
                .documentType(employeeCreationDto.getDocumentType())
                .documentNumber(employeeCreationDto.getDocumentNumber())
                .birthDate(employeeCreationDto.getBirthDate())
                .startDate(employeeCreationDto.getStartDate())
                .post(employeeCreationDto.getPost())
                .salary(employeeCreationDto.getSalary()).build();
        return employee;
    }

    public static EmployeeDto mapDomainToInformation(Employee employee){
        EmployeeDto employeeDto = EmployeeDto.builder()
                .names(employee.getNames())
                .lastNames(employee.getLastNames())
                .documentType(employee.getDocumentType())
                .documentNumber(employee.getDocumentNumber())
                .age(convertBirthDate(employee.getBirthDate()))
                .antiquity(convertStartDate(employee.getStartDate()))
                .post(employee.getPost())
                .salary(employee.getSalary()).build();
        return employeeDto;
    }

    private static String convertBirthDate(Date date){
        LocalDate today=  LocalDate.now();
        String result;
        LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthDate,today);
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        result = "years: "+ years + "- months: " + months + "- days: " + days;
        return result;
    }

    private static String convertStartDate(Date date){
        LocalDate today=  LocalDate.now();
        String result;
        LocalDate startDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(startDay,today);
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        result = "years: "+ years + "- months: " + months;
        return result;
    }
}
