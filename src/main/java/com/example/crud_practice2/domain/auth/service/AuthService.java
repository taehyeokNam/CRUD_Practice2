package com.example.crud_practice2.domain.auth.service;

import com.example.crud_practice2.common.CustomException;
import com.example.crud_practice2.common.JwtUtil;
import com.example.crud_practice2.common.PasswordEncoder;
import com.example.crud_practice2.domain.auth.dto.SigninRequest;
import com.example.crud_practice2.domain.auth.dto.SigninResponse;
import com.example.crud_practice2.domain.auth.dto.SignupRequest;
import com.example.crud_practice2.domain.auth.dto.SignupResponse;
import com.example.crud_practice2.domain.user.UserRole;
import com.example.crud_practice2.domain.user.entity.User;
import com.example.crud_practice2.domain.user.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public SignupResponse signup(SignupRequest signupRequest) {

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());
        UserRole userRoler = convertToUserRole(signupRequest.getUserRole());

        User user = new User(
                signupRequest.getUserName(),
                signupRequest.getEmail(),
                encodedPassword,
                userRoler
        );

        User savedUser = userRepository.save(user);

        String bearerToken = jwtUtil.createToken(
                savedUser.getId(),
                savedUser.getEmail(),
                userRoler
        );

        return new SignupResponse(bearerToken);
    }

    public SigninResponse signin(SigninRequest signinRequest) {

        User user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다"));

        if (!passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            throw new CustomException("잘못된 비밀번호입니다.");
        }

        String bearerToken = jwtUtil.createToken(
                user.getId(),
                user.getEmail(),
                convertToUserRole(signinRequest.getUserRole())
        );

        return new SigninResponse(bearerToken);
    }

    private UserRole convertToUserRole(String userRoleString) {
        try{
            return UserRole.valueOf(userRoleString.toUpperCase());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("잘못된 역할 정보입니다" + userRoleString);
        }
    }
}
