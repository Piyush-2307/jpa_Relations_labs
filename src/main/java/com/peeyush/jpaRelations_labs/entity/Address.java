package com.peeyush.jpaRelations_labs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(String street, String city){
        this.street = street;
        this.city = city;
    }

    public void setUser(User user){
        this.user = user;
        user.setAddress(this);
    }
}
