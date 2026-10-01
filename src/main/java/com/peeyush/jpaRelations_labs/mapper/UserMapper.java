package com.peeyush.jpaRelations_labs.mapper;

import com.peeyush.jpaRelations_labs.dto.AddressResponse;
import com.peeyush.jpaRelations_labs.dto.CreateUserRequest;
import com.peeyush.jpaRelations_labs.dto.OrderResponse;
import com.peeyush.jpaRelations_labs.dto.UserResponse;
import com.peeyush.jpaRelations_labs.entity.Address;
import com.peeyush.jpaRelations_labs.entity.Order;
import com.peeyush.jpaRelations_labs.entity.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {
    public User toEntity(CreateUserRequest request){
        return new User(request.getUsername(), request.getEmail(), request.getPassword(), request.getActivity());
    }

    public UserResponse toResponse(User user){

//        Address address = user.getAddress();

        AddressResponse addressResponse = null;

        if (user.getAddress() != null){
            addressResponse = new AddressResponse(
                    user.getAddress().getId(),
                    user.getAddress().getStreet(),
                    user.getAddress().getCity()
            );
        }

        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getActivity(), addressResponse);

    }

    public Address toAddress(CreateUserRequest request){
        return new Address(request.getStreet(), request.getCity());
    }
}
