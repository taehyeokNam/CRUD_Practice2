package com.example.crud_practice2.domain.todo.dto;

import com.example.crud_practice2.domain.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoGetSimpleRepsonse {

    private final String title;
    private final String userName;
    private final String description;
    private final int commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoGetSimpleRepsonse(Todo todo) {
        this.title = todo.getTitle();
        this.userName = todo.getUser().getUserName();
        this.description = todo.getDescription();
        this.commentCount = todo.getComments().size();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
