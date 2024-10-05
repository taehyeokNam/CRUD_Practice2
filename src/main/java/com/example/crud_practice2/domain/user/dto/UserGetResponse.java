package com.example.crud_practice2.domain.user.dto;

import com.example.crud_practice2.domain.user.entity.User;
import lombok.Getter;

@Getter
public class UserGetResponse {

    private final long id;
    private final String userName;
    private final String email;

    public UserGetResponse(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
    }
}
