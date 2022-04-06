package com.examen.repository.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String names;
    @Column(nullable = false)
    private String lastNames;
    @Column(nullable = false)
    private String typeDocument;
    @Column(nullable = false)
    private String numberDocument;
    @Column(nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private String post;
    @Column(nullable = false)
    private Double salary;

}
