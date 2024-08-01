package com.example.wanted_pre_onboarding_backend.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CommonResponse<T> {
    private int statusCode;
    private String responseMessage;
    private T data;

    public CommonResponse(final int statusCode, final String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    public static<T> CommonResponse<T> res(final int statusCode, final String responseMessage) {
        return res(statusCode, responseMessage, null);
    }

    public static<T> CommonResponse<T> res(final int statusCode, final String responseMessage, final T data) {
        return CommonResponse.<T>builder()
                .data(data)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }
}