package com.example.crud_practice2.domain.todo.entity;

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
    private String userName;
    private String title;
    private String description;

    public Todo(Long id, String userName, String title, String description) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.description = description;
    }
}
