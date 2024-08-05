package com.example.wanted_pre_onboarding_backend.response;

import com.example.wanted_pre_onboarding_backend.response.status.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private final Boolean success;
    private HttpStatus status;
    private String message;

    public ErrorResponse(Boolean success, ErrorCode errorCode) {
        this.success = success;
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }

    public static ErrorResponse of(Boolean success, ErrorCode errorCode) {
        return new ErrorResponse(success, errorCode);
    }
}
