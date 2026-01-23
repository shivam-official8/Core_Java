package com.shivam.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@ToString
@Data
public class UserProfile {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String email;

//    @Embedded
//    private Address address;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="city", column=@Column(name="home_city")),
            @AttributeOverride(name="state", column = @Column(name="home_state")),
            @AttributeOverride(name="pincode", column=@Column(name="home_pincode"))
    })
    @AssociationOverrides({
            @AssociationOverride(
                    name = "country",
                    joinColumns = @JoinColumn(name = "home_country_id")
            )
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column=@Column(name="office_city")),
            @AttributeOverride(name="state", column=@Column(name = "office_state")),
            @AttributeOverride(name="pincode", column=@Column(name="office_pincode"))
    })
    @AssociationOverrides({
            @AssociationOverride(
                    name = "country",
                    joinColumns = @JoinColumn(name = "office_country_id")
            )
    })
    private Address officeAddress;
}
