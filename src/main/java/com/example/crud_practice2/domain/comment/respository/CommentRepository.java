package com.example.crud_practice2.domain.comment.respository;

import com.example.crud_practice2.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByTodoId(long todoId);
}
