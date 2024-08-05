package com.example.wanted_pre_onboarding_backend.response.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "요청 파라미터가 올바르지 않습니다."),
    NOT_EXIST_COMPANY(HttpStatus.NOT_FOUND, "존재하지 않는 회사입니다."),
    NOT_EXIST_POST(HttpStatus.NOT_FOUND, "존재하지 않는 공고입니다."),
    NOT_EXIST_USER(HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러입니다.");

    private final HttpStatus status;
    private final String message;
}
