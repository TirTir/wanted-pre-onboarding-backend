package com.example.wanted_pre_onboarding_backend.dto;

import lombok.Data;

@Data
public class UserRequest {
    @Data
    public static class ApplyPost { // 채용공고 지원
        private int userId;
        private int postId;
    }
}
