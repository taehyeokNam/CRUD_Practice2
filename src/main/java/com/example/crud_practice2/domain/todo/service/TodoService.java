package com.example.crud_practice2.domain.todo.service;

import com.example.crud_practice2.domain.manager.entity.Manager;
import com.example.crud_practice2.domain.manager.repository.ManagerRepository;
import com.example.crud_practice2.domain.todo.dto.*;
import com.example.crud_practice2.domain.todo.entity.Todo;
import com.example.crud_practice2.domain.todo.respository.TodoRepository;
import com.example.crud_practice2.domain.user.dto.UserDto;
import com.example.crud_practice2.domain.user.entity.User;
import com.example.crud_practice2.domain.user.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;

    @Transactional
    public TodoCreateResponse createTodo(TodoCreateRequest todoCreateRequest) {

        User user = userRepository.findById(todoCreateRequest.getUserId()).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다"));

        Todo newTodo = new Todo(
                user,
                todoCreateRequest.getTitle(),
                todoCreateRequest.getDescription()
        );

        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoCreateResponse(savedTodo);
    }

    public TodoGetResponse getTodo(long todoId) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다"));

        List<UserDto> userDtos = new ArrayList<>();
        List<Manager> managers = managerRepository.findAllByTodoId(todo.getId());

        for (Manager manager : managers) {
            User user = userRepository.findById(manager.getUser().getId()).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다."));
            userDtos.add(new UserDto(user));
        }

        return new TodoGetResponse(todo, userDtos);
    }

    @Transactional
    public long updateTodo(long todoId, TodoUpdateRequest todoUpdateRequest) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다."));

        todo.updateTodo(
                todoUpdateRequest.getTitle(),
                todoUpdateRequest.getDescription()
        );

        return todoId;
    }

    public Page<TodoGetSimpleRepsonse> getTodos(int page, int size) {

        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(TodoGetSimpleRepsonse::new);
    }

    @Transactional
    public void deleteTodo(long todoId) {
        todoRepository.deleteById(todoId);
    }
}
