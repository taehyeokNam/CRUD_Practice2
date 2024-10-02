package com.example.crud_practice2.domain.todo.controller;

import com.example.crud_practice2.domain.todo.dto.TodoAddRequest;
import com.example.crud_practice2.domain.todo.dto.TodoAddResponse;
import com.example.crud_practice2.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public TodoAddResponse addTodo(@RequestBody TodoAddRequest todoAddRequest) {
        return todoService.addTodo(todoAddRequest);
    }

}
