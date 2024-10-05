package com.example.crud_practice2.domain.todo.dto;

import com.example.crud_practice2.domain.todo.entity.Todo;
import com.example.crud_practice2.domain.user.dto.UserDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class TodoGetResponse {

    private final String title;
    private final long userId;
    private final String userName;
    private final String email;
    private final String description;
    private final String weather;
    private final List<UserDto> userDtos;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final int commentCount;

    public TodoGetResponse(Todo todo, List<UserDto> userDtos) {

        this.title = todo.getTitle();
        this.userId = todo.getUser().getId();
        this.userName = todo.getUser().getUserName();
        this.email = todo.getUser().getEmail();
        this.description = todo.getDescription();
        this.weather = todo.getWeather();
        this.userDtos = userDtos;
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
        this.commentCount = todo.getComments().size();
    }
}
