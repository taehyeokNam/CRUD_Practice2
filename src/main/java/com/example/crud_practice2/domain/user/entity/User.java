package com.example.crud_practice2.domain.user.entity;

import com.example.crud_practice2.common.Timestamped;
import com.example.crud_practice2.domain.manager.entity.Manager;
import com.example.crud_practice2.domain.user.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    @OneToMany(mappedBy = "user")
    private List<Manager> managers;

    public User(String userName, String email, String password, UserRole userRole) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }
}
