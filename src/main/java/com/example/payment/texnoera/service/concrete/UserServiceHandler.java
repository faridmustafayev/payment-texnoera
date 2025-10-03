package com.example.payment.texnoera.service.concrete;

import com.example.payment.texnoera.dao.entity.UserEntity;
import com.example.payment.texnoera.dao.repository.UserRepository;
import com.example.payment.texnoera.dto.request.UserRequest;
import com.example.payment.texnoera.dto.response.UserResponse;
import com.example.payment.texnoera.exception.NotFoundException;
import com.example.payment.texnoera.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.payment.texnoera.exception.ExceptionConstants.USER_NOT_FOUND;
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

    @Override
    public UserResponse findUserById(Long id) {
        UserEntity userEntity = fetchUserIfExist(id);
        return UserResponse.builder()
                .id(userEntity.getId())
                .createdAt(userEntity.getCreatedAt())
                .name(userEntity.getName())
                .balance(userEntity.getBalance())
                .build();
    }

    @Override
    public List<UserResponse> findAllUsers() {
        return userRepository.findAll().stream()
                .map(response -> UserResponse.builder()
                        .balance(response.getBalance())
                        .id(response.getId())
                        .name(response.getName())
                        .createdAt(response.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    private UserEntity fetchUserIfExist(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMessage()));
    }
}
