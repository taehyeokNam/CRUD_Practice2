package com.example.crud_practice2.domain.todo.dto;

import com.example.crud_practice2.domain.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoAddResponse {

    private final long id;
    private final String title;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoAddResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
