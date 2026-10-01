package com.peeyush.jpaRelations_labs.service;

import com.peeyush.jpaRelations_labs.dto.*;
import com.peeyush.jpaRelations_labs.entity.Order;
import com.peeyush.jpaRelations_labs.entity.User;
import com.peeyush.jpaRelations_labs.enums.Activity;
import com.peeyush.jpaRelations_labs.mapper.UserMapper;
import com.peeyush.jpaRelations_labs.repository.OrderRepository;
import com.peeyush.jpaRelations_labs.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final OrderRepository orderRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, OrderRepository orderRepository){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.orderRepository = orderRepository;
    }

    public UserResponse createUser(CreateUserRequest request){
        User user = userMapper.toEntity(request);
        user.setActivity(Activity.ONLINE);
        user.setAddress(userMapper.toAddress(request));
        return userMapper.toResponse(userRepository.save(user));
    }

    public OrderResponse createOrder(CreateOrderRequest request){
        Order order = new Order(request.getName(), request.getAmount());
        Order savedOrder = orderRepository.save(order);
        return new OrderResponse(savedOrder.getId(), savedOrder.getName(), savedOrder.getAmount());
    }

    public OrderResponse order(Long userId, Long orderId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setUser(user);
        Order savedOrder = orderRepository.save(order);
        return new OrderResponse(savedOrder.getId(), savedOrder.getName(), savedOrder.getAmount());
    }

    public Page<UserResponse> findAll(Pageable pageable){
        return userRepository.findAll(pageable).map(userMapper::toResponse);
    }

    public UserResponse findByEmail(String email){
        return userMapper.toResponse(userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updatedUser(UpdateRequest request, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        return userMapper.toResponse(userRepository.save(user));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
