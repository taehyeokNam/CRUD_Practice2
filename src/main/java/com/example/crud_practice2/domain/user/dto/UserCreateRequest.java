package com.example.crud_practice2.domain.user.dto;

import lombok.Getter;

@Getter
public class UserCreateRequest {

    private String userName;
    private String email;
    private String password;
}
