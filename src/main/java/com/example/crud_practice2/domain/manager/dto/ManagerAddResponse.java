package com.example.crud_practice2.domain.manager.dto;

import com.example.crud_practice2.domain.manager.entity.Manager;
import com.example.crud_practice2.domain.todo.entity.Todo;
import lombok.Getter;

@Getter
public class ManagerAddResponse {

    private final long todoId;
    private final String todoName;
    private final long managerId;
    private final String managerName;

    public ManagerAddResponse(Todo todo, Manager manager) {
        this.todoId = todo.getId();
        this.todoName = todo.getTitle();
        this.managerId = manager.getUser().getId();
        this.managerName = manager.getUser().getUserName();
    }
}
