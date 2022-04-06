package com.examen.dto;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
    @Past
    private Date birthDate;
    @NotNull
    @Past
    private Date startDate;
    @NotNull
    @NotBlank
    private String post;
    @NotNull
    @Min(1)
    private Double salary;
}
