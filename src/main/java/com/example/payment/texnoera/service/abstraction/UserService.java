package com.example.payment.texnoera.service.abstraction;

import com.example.payment.texnoera.dto.request.UserRequest;
import com.example.payment.texnoera.dto.response.UserResponse;

public interface UserService {
    UserResponse saveUser(UserRequest request);
}
