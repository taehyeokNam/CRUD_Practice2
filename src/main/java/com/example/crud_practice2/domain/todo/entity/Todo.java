package com.example.crud_practice2.domain.todo.entity;

import com.example.crud_practice2.common.Timestamped;
import com.example.crud_practice2.domain.comment.entity.Comment;
import com.example.crud_practice2.domain.manager.entity.Manager;
import com.example.crud_practice2.domain.user.entity.User;
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
    private String title;
    private String description;
    private String weather;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "todo")
    List<Manager> managers = new ArrayList<>();

    @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
    List<Comment> comments = new ArrayList<>();

    public Todo(User user, String title, String weather, String description) {
        this.user = user;
        this.title = title;
        this.weather = weather;
        this.description = description;
    }

    public void updateTodo(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
