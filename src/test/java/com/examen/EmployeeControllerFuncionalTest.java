package com.examen;

import com.examen.dto.EmployeeCreationDto;
import com.examen.dto.EmployeeDto;
import com.examen.dto.ErrorDTO;
import com.examen.repository.EmployeeRepository;
import java.util.Date;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class EmployeeControllerFuncionalTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpEntity<?> entity;

    @Autowired
    EmployeeRepository employeeRepository;

    @AfterEach
    void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Test
    void testCreateEmployees_shouldReturnEmployeeDto() {
        //Given
        EmployeeCreationDto employeeCreationDto = EmployeeCreationDto.builder()
                .names("nahu")
                .lastNames("barrios")
                .documentType("DNI")
                .documentNumber("16345878")
                .birthDate(new Date(2000-04-01))
                .startDate(new Date(2020-03-02))
                .post("Empleado")
                .salary(1000.0).build();
        String endpointUrl = "/employees";

        entity = new HttpEntity(employeeCreationDto, null);
        //When
        ResponseEntity<EmployeeDto> response = testRestTemplate.exchange(
                endpointUrl,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                },
                Map.of()
        );
        //Then
        assertEquals(201, response.getStatusCode().value());
    }

    @Test
    void testCreateEmployees_shouldReturnBadRequest() {
        //Given
        EmployeeCreationDto employeeCreationDto = EmployeeCreationDto.builder()
                .names("")
                .lastNames("barrios")
                .documentType("DNI")
                .documentNumber("16345878")
                .birthDate(new Date(2000-04-01))
                .startDate(new Date(2020-03-02))
                .post("Empleado")
                .salary(1000.0).build();
        String endpointUrl = "/employees";

        entity = new HttpEntity(employeeCreationDto, null);
        //When
        ResponseEntity<EmployeeDto> response = testRestTemplate.exchange(
                endpointUrl,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                },
                Map.of()
        );
        //Then
        assertEquals(400, response.getStatusCode().value());
    }

}
