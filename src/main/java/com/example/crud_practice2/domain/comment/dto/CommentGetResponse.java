package com.example.crud_practice2.domain.comment.dto;

import com.example.crud_practice2.domain.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentGetResponse {

    private final long id;
    private final String userName;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentGetResponse(Comment comment) {
        this.id = comment.getId();
        this.userName = comment.getUserName();
        this.description = comment.getDescription();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
