package com.ra.md04_ss2_crudapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private LocalDate dateOfBirth;
    private double salary;
    private Boolean gender;
    private String address;
    private String company;
    private String Department;
//    @ManyToOne
//    @JoinColumn(name = "departmentID", referencedColumnName = "id")
//    private Department departmentID;

}
