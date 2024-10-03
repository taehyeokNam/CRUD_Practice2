package com.example.crud_practice2.domain.todo.service;

import com.example.crud_practice2.domain.todo.dto.TodoCreateRequest;
import com.example.crud_practice2.domain.todo.dto.TodoCreateResponse;
import com.example.crud_practice2.domain.todo.dto.TodoGetResponse;
import com.example.crud_practice2.domain.todo.dto.TodoUpdateRequest;
import com.example.crud_practice2.domain.todo.entity.Todo;
import com.example.crud_practice2.domain.todo.respository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoCreateResponse createTodo(TodoCreateRequest todoCreateRequest) {

        Todo newTodo = new Todo(
                todoCreateRequest.getUserName(),
                todoCreateRequest.getTitle(),
                todoCreateRequest.getDescription()
        );

        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoCreateResponse(savedTodo);
    }

    public TodoGetResponse getTodo(long todoId) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다"));

        return new TodoGetResponse(todo);
    }

    @Transactional
    public long updateTodo(long todoId, TodoUpdateRequest todoUpdateRequest) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다."));

        todo.updateTodo(
                todoUpdateRequest.getUserName(),
                todoUpdateRequest.getTitle(),
                todoUpdateRequest.getDescription()
        );

        return todoId;
    }

    public Page<TodoGetResponse> getTodos(int page, int size) {

        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo -> new TodoGetResponse(todo));
    }
}
