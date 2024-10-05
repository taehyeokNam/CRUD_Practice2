package com.example.crud_practice2.domain.auth.dto;

import lombok.Getter;

@Getter
public class SigninRequest {

    private String email;
    private String password;
    private String userRole;
}
