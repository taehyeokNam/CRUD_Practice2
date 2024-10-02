package com.example.crud_practice2.domain.todo.dto;

import com.example.crud_practice2.domain.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoCreateResponse {

    private final long id;
    private final String userName;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoCreateResponse(Todo todo) {
        this.id = todo.getId();
        this.userName = todo.getUserName();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
