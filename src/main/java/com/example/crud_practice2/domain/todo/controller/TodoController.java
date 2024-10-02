package com.example.crud_practice2.domain.todo.controller;

import com.example.crud_practice2.domain.todo.dto.TodoAddRequest;
import com.example.crud_practice2.domain.todo.dto.TodoAddResponse;
import com.example.crud_practice2.domain.todo.dto.TodoGetResponse;
import com.example.crud_practice2.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public TodoAddResponse addTodo(@RequestBody TodoAddRequest todoAddRequest) {
        return todoService.addTodo(todoAddRequest);
    }

    @GetMapping("/todos/{todoid}")
    public TodoGetResponse getTodo(@PathVariable long todoid) {
        return todoService.getTodo(todoid);
    }

}
