package com.example.crud_practice2.domain.todo.respository;

import com.example.crud_practice2.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);
}
