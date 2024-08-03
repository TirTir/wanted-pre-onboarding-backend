package com.example.wanted_pre_onboarding_backend.response;

import com.example.wanted_pre_onboarding_backend.response.status.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CommonResponse<T> {
    private SuccessCode successCode;
    private T data;

    public CommonResponse(SuccessCode statusCode) {
        this.successCode = statusCode;
        this.data = null;
    }

    public static<T> CommonResponse<T> res(SuccessCode statusCode) {
        return res(statusCode, null);
    }

    public static<T> CommonResponse<T> res(SuccessCode successCode, final T data) {
        return CommonResponse.<T>builder()
                .data(data)
                .successCode(successCode)
                .build();
    }
}