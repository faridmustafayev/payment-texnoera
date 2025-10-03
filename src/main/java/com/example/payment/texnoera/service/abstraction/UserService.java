package com.example.payment.texnoera.service.abstraction;

import com.example.payment.texnoera.dto.request.UserRequest;
import com.example.payment.texnoera.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse saveUser(UserRequest request);

    UserResponse findUserById(Long id);

    List<UserResponse> findAllUsers();
}
