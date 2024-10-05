package com.example.crud_practice2.domain.user.controller;

import com.example.crud_practice2.domain.user.dto.UserGetResponse;
import com.example.crud_practice2.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{userid}")
    public UserGetResponse getUser(@PathVariable long userid) {
        return userService.getUser(userid);
    }

    @GetMapping("/users")
    public List<UserGetResponse> getUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/users/{userid}")
    public void deleteUser(@PathVariable long userid) {
        userService.deleteUser(userid);
    }
}
