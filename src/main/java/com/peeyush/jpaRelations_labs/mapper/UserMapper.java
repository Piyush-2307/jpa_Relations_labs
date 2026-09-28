package com.peeyush.jpaRelations_labs.mapper;

import com.peeyush.jpaRelations_labs.dto.AddressResponse;
import com.peeyush.jpaRelations_labs.dto.CreateUserRequest;
import com.peeyush.jpaRelations_labs.dto.UserResponse;
import com.peeyush.jpaRelations_labs.entity.Address;
import com.peeyush.jpaRelations_labs.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(CreateUserRequest request){
        return new User(request.getUsername(), request.getEmail(), request.getPassword(), request.getActivity());
    }

    public UserResponse toResponse(User user){

        Address address = user.getAddress();

        AddressResponse addressResponse = null;

        if (address != null){
            addressResponse = new AddressResponse(
                    address.getId(),
                    address.getStreet(),
                    address.getCity()
            );
        }

        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getActivity(), addressResponse);

    }
}
