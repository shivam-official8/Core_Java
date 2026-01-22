package com.shivam.collegemanagementjpamapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@JsonIgnoreProperties("hibernateLazyInitializer")
public class IDCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    @OneToOne(mappedBy = "idCard", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idCard")
//    @JsonBackReference
    private Student student;
}
