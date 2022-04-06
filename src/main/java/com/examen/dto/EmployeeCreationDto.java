package com.examen.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmployeeCreationDto {
    @NotNull
    @NotBlank
    private String names;
    @NotNull
    @NotBlank
    private String lastNames;
    @NotNull
    @NotBlank
    private String typeDocument;
    @NotNull
    @NotBlank
    private String numberDocument;
    @NotNull
    private Date birthDate;
    @NotNull
    private Date startDate;
    @NotNull
    @NotBlank
    private String post;
    @NotNull
    private Double salary;
}
