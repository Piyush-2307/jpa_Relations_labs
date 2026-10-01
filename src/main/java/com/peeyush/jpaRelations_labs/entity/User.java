package com.peeyush.jpaRelations_labs.entity;

import com.peeyush.jpaRelations_labs.enums.Activity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "activity")
    @Enumerated(EnumType.STRING)
    private Activity activity;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public User(String username, String email, String password, Activity activity){
        this.username = username;
        this.email = email;
        this.password = password;
        this.activity = activity;
    }

    public void setAddress(Address address){
        this.address = address;

        if (address != null){
            address.setUser(this);
        }
    }

    public void addOrder(Order order){
        orders.add(order);
        order.setUser(this);
    }
}
