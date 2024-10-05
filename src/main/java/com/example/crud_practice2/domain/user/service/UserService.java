package com.example.crud_practice2.domain.user.service;

import com.example.crud_practice2.common.JwtUtil;
import com.example.crud_practice2.common.PasswordEncoder;
import com.example.crud_practice2.domain.user.dto.UserGetResponse;
import com.example.crud_practice2.domain.user.entity.User;
import com.example.crud_practice2.domain.user.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    public UserGetResponse getUser(long userId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다"));

        return new UserGetResponse(user);
    }

    public List<UserGetResponse> getUsers() {

        List<User> users = userRepository.findAll();
        List<UserGetResponse> dtoList = new ArrayList<>();

        for (User user : users) {
            dtoList.add(new UserGetResponse(user));
        }

        return dtoList;
    }

    @Transactional
    public void deleteUser(long userId) {

        userRepository.deleteById(userId);
    }
}
