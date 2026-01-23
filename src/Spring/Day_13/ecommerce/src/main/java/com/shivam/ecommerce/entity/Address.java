package com.shivam.ecommerce.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Embeddable
@Data
@ToString
public class Address {
    private String city;
    private String state;
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}

