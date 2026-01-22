package com.shivam.collegemanagementjpamapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Professor {
    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties("professors")
    private Department department;
}
