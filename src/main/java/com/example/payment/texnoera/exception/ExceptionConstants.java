package com.example.payment.texnoera.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occurred !"),
    INSUFFICIENT_BALANCE_EXCEPTION("INSUFFICIENT_BALANCE_EXCEPTION", "insufficient balance"),
    VALIDATION_EXCEPTION("VALIDATION_EXCEPTION", "validation exception"),
    HTTP_METHOD_IS_NOT_CORRECT("HTTP_METHOD_IS_NOT_CORRECT", "Http method is not correct"),
    USER_NOT_FOUND("USER_NOT_FOUND", "User not found");

    private final String code;
    private final String message;

    public String getMessage(Long id) {
        if ((this == USER_NOT_FOUND) && id != null) {
            return String.format("No %s with id (ID: %s) was found",
                    this.name().toLowerCase().replace("_not_found", ""), id);
        }
        return this.message;
    }
}
