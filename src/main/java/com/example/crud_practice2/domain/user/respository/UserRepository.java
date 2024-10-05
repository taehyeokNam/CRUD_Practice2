package com.example.crud_practice2.domain.user.respository;

import com.example.crud_practice2.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
