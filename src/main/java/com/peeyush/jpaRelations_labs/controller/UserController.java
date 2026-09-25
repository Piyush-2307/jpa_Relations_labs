package com.peeyush.jpaRelations_labs.controller;

import com.peeyush.jpaRelations_labs.dto.CreateUserRequest;
import com.peeyush.jpaRelations_labs.dto.UpdateRequest;
import com.peeyush.jpaRelations_labs.dto.UserResponse;
import com.peeyush.jpaRelations_labs.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    public Page<UserResponse> findAll(Pageable pageable){
        return userService.findAll(pageable);
    }

    @GetMapping("/{email}")
    public UserResponse findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @PatchMapping("/{id}")
    public UserResponse updateUser(@Valid @RequestBody UpdateRequest request, @PathVariable Long id){
        return userService.updatedUser(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
