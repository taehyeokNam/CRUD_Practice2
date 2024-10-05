package com.example.crud_practice2.domain.auth;

import lombok.Getter;

@Getter
public class AuthUser {

    private final long id;
    private final String email;

    public AuthUser(long id, String email) {
        this.id = id;
        this.email = email;
    }
}
