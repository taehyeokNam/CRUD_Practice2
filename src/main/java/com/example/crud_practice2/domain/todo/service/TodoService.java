package com.example.crud_practice2.domain.todo.service;

import com.example.crud_practice2.domain.todo.dto.TodoAddRequest;
import com.example.crud_practice2.domain.todo.dto.TodoAddResponse;
import com.example.crud_practice2.domain.todo.dto.TodoGetResponse;
import com.example.crud_practice2.domain.todo.entity.Todo;
import com.example.crud_practice2.domain.todo.respository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoAddResponse addTodo(TodoAddRequest todoAddRequest) {

        Todo newTodo = new Todo(
                todoAddRequest.getTitle(),
                todoAddRequest.getManagerName(),
                todoAddRequest.getPassword()
        );

        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoAddResponse(savedTodo);
    }

    public TodoGetResponse getTodo(long todoId) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다"));

        return new TodoGetResponse(todo);


    }
}
