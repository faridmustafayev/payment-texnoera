package com.example.payment.texnoera.service.concrete;

import com.example.payment.texnoera.dao.entity.UserEntity;
import com.example.payment.texnoera.dao.repository.UserRepository;
import com.example.payment.texnoera.dto.request.UserRequest;
import com.example.payment.texnoera.dto.response.UserResponse;
import com.example.payment.texnoera.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserServiceHandler implements UserService {
    UserRepository userRepository;

    @Override
    public UserResponse saveUser(UserRequest request) {

        UserEntity userEntity = UserEntity.builder()
                .balance(request.getBalance())
                .name(request.getName())
                .build();

        userRepository.save(userEntity);

        return UserResponse.builder()
                .id(userEntity.getId())
                .balance(userEntity.getBalance())
                .name(userEntity.getName())
                .createdAt(userEntity.getCreatedAt())
                .build();
    }
}
