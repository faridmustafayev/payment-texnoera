package com.example.payment.texnoera.service.abstraction;

import com.example.payment.texnoera.dto.request.PaymentRequest;
import com.example.payment.texnoera.dto.response.PaymentResponse;

public interface PaymentService {
    PaymentResponse makePayment(PaymentRequest request);
}
