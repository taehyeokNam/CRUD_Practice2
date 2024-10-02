package com.example.crud_practice2.domain.todo.dto;

import com.example.crud_practice2.domain.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoGetResponse {

    private final long id;
    private final String title;
    private final String managerName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public TodoGetResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.managerName = todo.getManagerName();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
