package com.example.payment.texnoera.service.concrete;

import com.example.payment.texnoera.dao.entity.PaymentEntity;
import com.example.payment.texnoera.dao.entity.UserEntity;
import com.example.payment.texnoera.dao.repository.PaymentRepository;
import com.example.payment.texnoera.dao.repository.UserRepository;
import com.example.payment.texnoera.dto.request.PaymentRequest;
import com.example.payment.texnoera.dto.response.PaymentResponse;
import com.example.payment.texnoera.exception.InsufficientException;
import com.example.payment.texnoera.exception.NotFoundException;
import com.example.payment.texnoera.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.payment.texnoera.exception.ExceptionConstants.INSUFFICIENT_BALANCE_EXCEPTION;
import static com.example.payment.texnoera.exception.ExceptionConstants.USER_NOT_FOUND;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PaymentServiceImpl implements PaymentService {
    PaymentRepository paymentRepository;
    UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PaymentResponse makePayment(PaymentRequest request) {

        UserEntity userEntity = userRepository.findById(request.getUserId()).orElseThrow(() ->
                new NotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMessage()));

        if (userEntity.getBalance().compareTo(request.getAmount()) < 0) {
            throw new InsufficientException(INSUFFICIENT_BALANCE_EXCEPTION.getCode(), INSUFFICIENT_BALANCE_EXCEPTION.getMessage());
        }

        userEntity.setBalance(userEntity.getBalance().subtract(request.getAmount()));
        userRepository.save(userEntity);

        PaymentEntity payment = PaymentEntity.builder()
                .userId(request.getUserId())
                .amount(request.getAmount())
                .build();

        paymentRepository.save(payment);

        return PaymentResponse.builder()
                .userId(payment.getUserId())
                .amount(payment.getAmount())
                .id(payment.getId())
                .build();
    }
}
