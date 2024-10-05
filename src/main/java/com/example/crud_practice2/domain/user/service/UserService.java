package com.example.crud_practice2.domain.user.service;

import com.example.crud_practice2.common.JwtUtil;
import com.example.crud_practice2.common.PasswordEncoder;
import com.example.crud_practice2.domain.user.dto.UserCreateRequest;
import com.example.crud_practice2.domain.user.dto.UserCreateResponse;
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

    @Transactional
    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {

        if (userRepository.existsByEmail(userCreateRequest.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(userCreateRequest.getPassword());

        User user = new User(
                userCreateRequest.getUserName(),
                userCreateRequest.getEmail(),
                encodedPassword
        );

        User savedUser = userRepository.save(user);

        String bearerToken = jwtUtil.createToken(
                savedUser.getId(),
                savedUser.getUserName(),
                savedUser.getEmail()
        );

        return new UserCreateResponse(bearerToken);
    }

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
