package com.example.crud_practice2.domain.comment.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequest {

    private String userName;
    private String description;

}
