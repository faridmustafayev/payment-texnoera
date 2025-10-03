package com.example.payment.texnoera.exception;

import lombok.Getter;

@Getter
public class InsufficientException extends RuntimeException {
    private final String code;
    public InsufficientException(String code, String message) {
        super(message);
        this.code = code;
    }
}
