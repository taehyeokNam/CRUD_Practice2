package com.example.crud_practice2.domain.auth.service;

import com.example.crud_practice2.domain.user.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
}
