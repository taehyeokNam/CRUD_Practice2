package com.example.crud_practice2.domain.manager.dto;

import lombok.Getter;

@Getter
public class ManagerAddRequest {

    private long todoUserId;
    private long managerUserId;
}
