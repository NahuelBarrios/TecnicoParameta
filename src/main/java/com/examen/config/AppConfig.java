package com.examen.config;

import com.examen.repository.EmployeeRepository;
import com.examen.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository){
        return new EmployeeService(employeeRepository);
    }

}
