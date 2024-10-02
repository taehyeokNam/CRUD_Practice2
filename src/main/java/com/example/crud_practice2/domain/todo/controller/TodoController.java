package com.example.crud_practice2.domain.todo.controller;

import com.example.crud_practice2.domain.todo.dto.TodoCreateRequest;
import com.example.crud_practice2.domain.todo.dto.TodoCreateResponse;
import com.example.crud_practice2.domain.todo.dto.TodoGetResponse;
import com.example.crud_practice2.domain.todo.dto.TodoUpdateRequest;
import com.example.crud_practice2.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public TodoCreateResponse createTodo(@RequestBody TodoCreateRequest todoCreateRequest) {
        return todoService.createTodo(todoCreateRequest);
    }

    @GetMapping("/todos/{todoid}")
    public TodoGetResponse getTodo(@PathVariable long todoid) {
        return todoService.getTodo(todoid);
    }

    @PatchMapping("/todos/{todoid}")
    public TodoGetResponse updatdTodo(@PathVariable long todoid, @RequestBody TodoUpdateRequest todoUpdateRequest) {
        todoService.updateTodo(todoid, todoUpdateRequest);
        return todoService.getTodo(todoid);
    }

}
