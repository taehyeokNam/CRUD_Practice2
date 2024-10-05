package com.example.crud_practice2.domain.auth.controller;

import com.example.crud_practice2.domain.auth.dto.SigninRequest;
import com.example.crud_practice2.domain.auth.dto.SigninResponse;
import com.example.crud_practice2.domain.auth.dto.SignupRequest;
import com.example.crud_practice2.domain.auth.dto.SignupResponse;
import com.example.crud_practice2.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthContoller {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public SignupResponse signup(@RequestBody SignupRequest signupRequest) {
        return authService.signup(signupRequest);
    }

    @PostMapping("/auth/signin")
    public SigninResponse singin(@RequestBody SigninRequest signinRequest) {
        return authService.signin(signinRequest);
    }

}
