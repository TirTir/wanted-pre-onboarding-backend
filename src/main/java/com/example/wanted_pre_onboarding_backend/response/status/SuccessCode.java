package com.example.wanted_pre_onboarding_backend.response.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    FETCH_SUCCESS(HttpStatus.OK, "채용 공고 목록 조회 성공"),
    FETCH_SINGLE_SUCCESS(HttpStatus.OK, "채용 공고 조회 성공"),
    REGISTER_SUCCESS(HttpStatus.OK, "채용 공고 등록 성공"),
    UPDATE_SUCCESS(HttpStatus.OK, "채용 공고 수정 성공"),
    DELETE_SUCCESS(HttpStatus.OK, "채용 공고 삭제 성공");

    private final HttpStatus status;
    private final String message;
}
