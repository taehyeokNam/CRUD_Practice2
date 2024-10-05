package com.example.crud_practice2.domain.manager.repository;

import com.example.crud_practice2.domain.manager.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    List<Manager> findAllByTodoId(long todoId);
}
