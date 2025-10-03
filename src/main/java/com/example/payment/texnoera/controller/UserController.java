package com.example.payment.texnoera.controller;

import com.example.payment.texnoera.dao.entity.UserEntity;
import com.example.payment.texnoera.dao.repository.UserRepository;
import com.example.payment.texnoera.dto.request.UserRequest;
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
    UserRepository userRepository;

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveUser(@RequestBody UserRequest request) {

        UserEntity userEntity = UserEntity.builder()
                .balance(request.getBalance())
                .name(request.getName())
                .build();

        userRepository.save(userEntity);

    }

}
