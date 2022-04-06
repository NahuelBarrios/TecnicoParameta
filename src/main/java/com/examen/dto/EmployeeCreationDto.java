package com.examen.dto;


import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmployeeCreationDto implements Serializable {
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
    @NotBlank
    private Date birthDate;
    @NotNull
    @NotBlank
    private Date startDate;
    @NotNull
    @NotBlank
    private String post;
    @NotNull
    @NotBlank
    private Double salary;
}
