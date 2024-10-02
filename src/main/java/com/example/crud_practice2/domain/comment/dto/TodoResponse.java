package com.example.crud_practice2.domain.comment.dto;

import com.example.crud_practice2.domain.todo.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponse {

    private final long id;
    private final String userName;
    private final String title;
    private final String description;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.userName = todo.getUserName();;
        this.title = todo.getTitle();
        this.description = todo.getDescription();
    }
}
