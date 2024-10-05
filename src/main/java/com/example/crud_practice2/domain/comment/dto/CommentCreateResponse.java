package com.example.crud_practice2.domain.comment.dto;

import com.example.crud_practice2.domain.comment.entity.Comment;
import lombok.Getter;

@Getter
public class CommentCreateResponse {

    private final long id;
    private final String userName;
    private final String description;

    public CommentCreateResponse(Comment comment) {
        this.id = comment.getId();
        this.userName = comment.getUser().getUserName();
        this.description = comment.getDescription();
    }
}
