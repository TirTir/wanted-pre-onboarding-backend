package com.example.wanted_pre_onboarding_backend.response;

import com.example.wanted_pre_onboarding_backend.response.status.ErrorCode;
import com.example.wanted_pre_onboarding_backend.response.status.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class CommonResponse<T> {
    private HttpStatus status;
    private String message;
    private T data;

    public CommonResponse(SuccessCode successCode) {
        this.status = successCode.getStatus();
        this.message = successCode.getMessage();
    }

    public static<T> CommonResponse<T> res(SuccessCode successCode) {
        return new CommonResponse(successCode);
    }

    public static<T> CommonResponse<T> res(SuccessCode successCode, final T data) {
        return CommonResponse.<T>builder()
                .status(successCode.getStatus())
                .message(successCode.getMessage())
                .data(data)
                .build();
    }
}