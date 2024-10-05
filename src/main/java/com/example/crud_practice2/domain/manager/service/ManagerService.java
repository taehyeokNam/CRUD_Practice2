package com.example.crud_practice2.domain.manager.service;

import com.example.crud_practice2.domain.manager.dto.ManagerAddRequest;
import com.example.crud_practice2.domain.manager.dto.ManagerAddResponse;
import com.example.crud_practice2.domain.manager.dto.ManagerGetResponse;
import com.example.crud_practice2.domain.manager.entity.Manager;
import com.example.crud_practice2.domain.manager.repository.ManagerRepository;
import com.example.crud_practice2.domain.todo.entity.Todo;
import com.example.crud_practice2.domain.todo.respository.TodoRepository;
import com.example.crud_practice2.domain.user.entity.User;
import com.example.crud_practice2.domain.user.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;

    @Transactional
    public ManagerAddResponse addManager(long todoId, ManagerAddRequest managerAddRequest) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다"));

        User user = userRepository.findById(managerAddRequest.getTodoUserId()).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다"));

        if (!(todo.getUser() != null &&
                ObjectUtils.nullSafeEquals(todo.getUser().getId(), user.getId()))) {
            throw new IllegalArgumentException("일정을 만든 유저만 담당자를 등록할 수 있습니다");
        }

        User manager = userRepository.findById(managerAddRequest.getManagerUserId()).orElseThrow(()-> new NullPointerException("존재하지 않는 유저입니다"));

        Manager newManager = new Manager(todo, manager);

        Manager savedManager = managerRepository.save(newManager);

        return new ManagerAddResponse(todo, savedManager);

    }

    public List<ManagerGetResponse> getManagers(long todoId) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new NullPointerException("존재하지 않는 일정입니다"));

        //List<Manager> managerList = todo.getManagers();
        List<Manager> managerList = managerRepository.findAllByTodoId(todoId);

        List<ManagerGetResponse> dtoList = new ArrayList<>();

        for (Manager manager : managerList) {
            dtoList.add(new ManagerGetResponse(manager));
        }

        return dtoList;
    }
}
