package com.example.crud_practice2.domain.auth.dto;

import lombok.Getter;

@Getter
public class SignupRequest {

    private String userName;
    private String email;
    private String password;
    private String userRole;
}
