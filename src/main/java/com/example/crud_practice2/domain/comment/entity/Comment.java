package com.example.crud_practice2.domain.comment.entity;

import com.example.crud_practice2.common.Timestamped;
import com.example.crud_practice2.domain.todo.entity.Todo;
import com.example.crud_practice2.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(Todo todo, User user, String description) {
        this.todo = todo;
        this.user = user;
        this.description = description;
    }

    public void updateComment(String description) {
        this.description = description;
    }
}
