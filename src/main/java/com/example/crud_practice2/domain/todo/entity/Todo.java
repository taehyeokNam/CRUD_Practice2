package com.example.crud_practice2.domain.todo.entity;

import com.example.crud_practice2.common.Timestamped;
import com.example.crud_practice2.domain.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;
    private String userName;
    private String title;
    private String description;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
    List<Comment> comments = new ArrayList<>();

    public Todo(String userName, String title, String description) {
        this.userName = userName;
        this.title = title;
        this.description = description;
    }

    public void updateTodo(String userName, String title, String description) {
        this.userName = userName;
        this.title = title;
        this.description = description;
    }
}
