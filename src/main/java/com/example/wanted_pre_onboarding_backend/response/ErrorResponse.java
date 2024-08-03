package com.example.wanted_pre_onboarding_backend.response;

import com.example.wanted_pre_onboarding_backend.response.status.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private final Boolean success;
    private ErrorCode errorCode;

    public static ErrorResponse of(Boolean success, ErrorCode errorCode) {
        return new ErrorResponse(success, errorCode);
    }
}
