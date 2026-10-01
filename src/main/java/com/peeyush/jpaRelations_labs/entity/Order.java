package com.peeyush.jpaRelations_labs.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order(String name, int amount){
        this.name = name;
        this.amount = amount;
    }
}

