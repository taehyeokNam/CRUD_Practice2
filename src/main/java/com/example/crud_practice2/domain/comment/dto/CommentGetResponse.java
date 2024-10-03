package com.example.crud_practice2.domain.comment.dto;

import com.example.crud_practice2.domain.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponse {

    private final String userName;
    private final String description;
    private final LocalDateTime modifiedAt;

    public CommentGetResponse(Comment comment) {
        this.userName = comment.getUserName();
        this.description = comment.getDescription();
        this.modifiedAt = comment.getModifiedAt();
    }
}
