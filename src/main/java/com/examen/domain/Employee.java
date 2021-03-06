package com.examen.domain;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private Long id;
    private String names;
    private String lastNames;
    private String documentType;
    private String documentNumber;
    private Date birthDate;
    private Date startDate;
    private String post;
    private Double salary;
}
