package com.example.wanted_pre_onboarding_backend.response.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    REGISTER_SUCCESS(HttpStatus.OK, "채용 공고 등록 성공");

    private final HttpStatus status;
    private final String message;
}
