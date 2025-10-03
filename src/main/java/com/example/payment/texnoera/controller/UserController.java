package com.example.payment.texnoera.controller;

import com.example.payment.texnoera.dto.request.UserRequest;
import com.example.payment.texnoera.dto.response.UserResponse;
import com.example.payment.texnoera.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    @ResponseStatus(CREATED)
    public UserResponse saveUser(@RequestBody UserRequest request) {
        return userService.saveUser(request);
    }

}
