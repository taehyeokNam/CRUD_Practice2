package com.example.crud_practice2.domain.todo.dto;

import lombok.Getter;

@Getter
public class TodoCreateRequest {

    private String userName;
    private String title;
    private String description;

}
