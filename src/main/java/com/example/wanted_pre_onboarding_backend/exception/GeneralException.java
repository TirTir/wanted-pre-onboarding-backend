package com.example.wanted_pre_onboarding_backend.exception;

import com.example.wanted_pre_onboarding_backend.response.status.ErrorCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralException extends RuntimeException {
    private final ErrorCode errorCode;

    public GeneralException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public GeneralException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode;
    }
}