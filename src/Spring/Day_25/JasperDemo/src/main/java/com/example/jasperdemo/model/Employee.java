package com.example.jasperdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name="EMPLOYEE_TBL")
public class Employee {
    @Id
    private Long id;

    private String name;
    private String designation;
    private double salary;
    private String doj;
}
