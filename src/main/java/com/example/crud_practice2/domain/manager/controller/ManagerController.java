package com.example.crud_practice2.domain.manager.controller;

import com.example.crud_practice2.domain.manager.dto.ManagerAddRequest;
import com.example.crud_practice2.domain.manager.dto.ManagerAddResponse;
import com.example.crud_practice2.domain.manager.dto.ManagerGetResponse;
import com.example.crud_practice2.domain.manager.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/todos/{todoid}/managers")
    public ManagerAddResponse addManager(@PathVariable long todoid, @RequestBody ManagerAddRequest managerAddRequest) {
        return managerService.addManager(todoid, managerAddRequest);
    }

    @GetMapping("/todos/{todoid}/managers")
    public List<ManagerGetResponse> getManagers(@PathVariable long todoid) {
        return managerService.getManagers(todoid);
    }

}
