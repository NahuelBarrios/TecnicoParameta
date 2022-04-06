package com.examen.controller.impl;

import com.examen.controller.IEmployeeController;
import com.examen.domain.Employee;
import com.examen.dto.EmployeeCreationDto;
import com.examen.dto.EmployeeInformation;
import com.examen.dto.ErrorDTO;
import com.examen.exception.EmployeeNotFoundException;
import com.examen.mapper.EmployeeMapper;
import com.examen.service.EmployeeService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements IEmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Override
    public EmployeeInformation employeeCreate(EmployeeCreationDto employeeCreationDto){
            Employee employee = EmployeeMapper.mapCreationToDomain(employeeCreationDto);
            EmployeeInformation employeeInformation = EmployeeMapper.mapDomainToInformation(employee);
            if(employeeInformation.getAge()>=18){
                employeeService.createEmployee(employee);
                return employeeInformation;
            }
            else{
                throw new EmployeeNotFoundException(String.format("es menor de edad"));
            }
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleEmployeeNotFoundExceptions(EmployeeNotFoundException ex) {
        ErrorDTO characterNotFound = ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND)
                .message(ex.getMessage()).build();
        return new ResponseEntity(characterNotFound, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
