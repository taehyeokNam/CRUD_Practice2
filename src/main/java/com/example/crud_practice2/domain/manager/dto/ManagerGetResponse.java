package com.example.crud_practice2.domain.manager.dto;

import com.example.crud_practice2.domain.manager.entity.Manager;

public class ManagerGetResponse {

    private final String managerName;

    public ManagerGetResponse(Manager manager) {
        this.managerName = manager.getUser().getUserName();
    }
}
