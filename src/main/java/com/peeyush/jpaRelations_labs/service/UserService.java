package com.peeyush.jpaRelations_labs.service;

import com.peeyush.jpaRelations_labs.dto.CreateUserRequest;
import com.peeyush.jpaRelations_labs.dto.UpdateRequest;
import com.peeyush.jpaRelations_labs.dto.UserResponse;
import com.peeyush.jpaRelations_labs.entity.User;
import com.peeyush.jpaRelations_labs.enums.Activity;
import com.peeyush.jpaRelations_labs.mapper.UserMapper;
import com.peeyush.jpaRelations_labs.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse createUser(CreateUserRequest request){
        User user = userMapper.toEntity(request);
        user.setActivity(Activity.ONLINE);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    public Page<UserResponse> findAll(Pageable pageable){
        return userRepository.findAll(pageable).map(userMapper::toResponse);
    }

    public UserResponse findByEmail(String email){
        return userMapper.toResponse(userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updatedUser(UpdateRequest request, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not fount"));
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        return userMapper.toResponse(userRepository.save(user));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
