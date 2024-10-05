package com.example.crud_practice2.domain.user.dto;

import lombok.Getter;

@Getter
public class UserCreateResponse {

   private final String bearerToken;

    public UserCreateResponse(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
