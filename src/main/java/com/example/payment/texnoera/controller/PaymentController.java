package com.example.payment.texnoera.controller;

import com.example.payment.texnoera.dto.request.PaymentRequest;
import com.example.payment.texnoera.dto.response.PaymentResponse;
import com.example.payment.texnoera.service.abstraction.PaymentService;
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
@RequestMapping("v1/payments")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PaymentController {
    PaymentService paymentService;

    @PostMapping
    @ResponseStatus(CREATED)
    public PaymentResponse makePayment(@RequestBody PaymentRequest request) {
        return paymentService.makePayment(request);
    }

}
