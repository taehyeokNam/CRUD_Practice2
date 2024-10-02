package com.example.crud_practice2.domain.comment.service;

import com.example.crud_practice2.domain.comment.dto.CommentCreateRequest;
import com.example.crud_practice2.domain.comment.dto.CommentCreateResponse;
import com.example.crud_practice2.domain.comment.dto.CommentGetResponse;
import com.example.crud_practice2.domain.comment.dto.CommentUpdateRequest;
import com.example.crud_practice2.domain.comment.entity.Comment;
import com.example.crud_practice2.domain.comment.respository.CommentRepository;
import com.example.crud_practice2.domain.todo.entity.Todo;
import com.example.crud_practice2.domain.todo.respository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentCreateResponse createComment(long todoId, CommentCreateRequest commentCreateRequest) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다"));

        Comment comment = new Comment(
                todo,
                commentCreateRequest.getUserName(),
                commentCreateRequest.getDescription()
        );

        Comment savedComment = commentRepository.save(comment);

        return new CommentCreateResponse(savedComment);

    }

    public CommentGetResponse getComment(long commentId) {

        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("존재하지 않는 댓글입니다."));

        return new CommentGetResponse(comment);
    }

    public List<CommentGetResponse> getComments(long todoId) {

        List<Comment> commentList =  todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다")).getComments();
        List<CommentGetResponse> dtoList = new ArrayList<>();

        for (Comment comment : commentList) {
            dtoList.add(new CommentGetResponse(comment));
        }

        return dtoList;
    }

    @Transactional
    public void updateComment(long commentId, CommentUpdateRequest commentUpdateRequest) {

        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("존재하지 않는 댓글입니다."));

        comment.updateComment(
                commentUpdateRequest.getUserName(),
                commentUpdateRequest.getDescription()
        );

    }

    @Transactional
    public void deleteComment(long commentId) {
        commentRepository.deleteById(commentId);
    }
}
