package com.example.crud_practice2.domain.comment.entity;

import com.example.crud_practice2.common.Timestamped;
import com.example.crud_practice2.domain.todo.entity.Todo;
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
    private String userName;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    Todo todo;

    public Comment(Todo todo, String userName, String description) {
        this.todo = todo;
        this.userName = userName;
        this.description = description;
    }

    public void updateComment(String userName, String description) {
        this.userName = userName;
        this.description = description;
    }
}
