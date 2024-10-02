package com.example.crud_practice2.domain.comment.controller;

import com.example.crud_practice2.domain.comment.dto.CommentCreateRequest;
import com.example.crud_practice2.domain.comment.dto.CommentCreateResponse;
import com.example.crud_practice2.domain.comment.dto.CommentGetResponse;
import com.example.crud_practice2.domain.comment.dto.CommentUpdateRequest;
import com.example.crud_practice2.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoid}/comments")
    public CommentCreateResponse createComment(@PathVariable long todoid, @RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.createComment(todoid, commentCreateRequest);
    }

    @GetMapping("/todos/{todoid}/comments/{commentid}")
    public CommentGetResponse getComment(@PathVariable long commentid) {
        return commentService.getComment(commentid);
    }

    @GetMapping("/todos/{todoid}/comments")
    public List<CommentGetResponse> getComments(@PathVariable long todoid) {
        return commentService.getComments(todoid);
    }

    @PatchMapping("/todos/{todoid}/comments/{commentid}")
    public CommentGetResponse updateComment(@PathVariable long commentid, @RequestBody CommentUpdateRequest commentUpdateRequest) {
        commentService.updateComment(commentid, commentUpdateRequest);
        return commentService.getComment(commentid);
    }

    @DeleteMapping("/todos/{todoid}/comments/{commentid}")
    public void deleteComment(@PathVariable long commentid) {
        commentService.deleteComment(commentid);
    }
}
