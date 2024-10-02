package com.example.crud_practice2.domain.todo.entity;

import com.example.crud_practice2.domain.todo.Timestamped;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String managerName;
    private String password;

    public Todo(String title, String managerName, String password) {
        this.title = title;
        this.managerName = managerName;
        this.password = password;
    }
}
