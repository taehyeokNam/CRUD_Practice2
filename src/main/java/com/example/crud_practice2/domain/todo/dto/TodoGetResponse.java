package com.example.crud_practice2.domain.todo.dto;

import com.example.crud_practice2.domain.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoGetResponse {

    private final String userName;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final int commentCount;

    public TodoGetResponse(Todo todo) {
        this.userName = todo.getUserName();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
        this.commentCount = todo.getComments().size();
    }
}
