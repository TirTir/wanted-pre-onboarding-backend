package com.example.wanted_pre_onboarding_backend.exception;

import com.example.wanted_pre_onboarding_backend.response.ErrorResponse;
import com.example.wanted_pre_onboarding_backend.response.status.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(GeneralException e) {
        ErrorResponse errorResponse = ErrorResponse.of(false, e.getErrorCode());
        return new ResponseEntity<>(errorResponse, e.getErrorCode().getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = ErrorResponse.of(false, ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorResponse, ErrorCode.INTERNAL_SERVER_ERROR.getStatus());
    }
}