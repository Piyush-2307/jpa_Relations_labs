package com.peeyush.jpaRelations_labs.entity;

import com.peeyush.jpaRelations_labs.enums.Activity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public User(String username, String email, String password, Activity activity){
        this.username = username;
        this.email = email;
        this.password = password;
        this.activity = activity;
    }
}
