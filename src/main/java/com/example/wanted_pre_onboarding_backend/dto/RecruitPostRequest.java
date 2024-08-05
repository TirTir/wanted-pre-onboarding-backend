package com.example.wanted_pre_onboarding_backend.dto;

import lombok.Data;

@Data
public class RecruitPostRequest {
    private int companyId;
    private String companyName;
    private String nation;
    private String region;
    private String position;
    private int reward;
    private String description;
    private String skills;

    @Data
    public static class RegisterPost { // 채용공고 등록
        private int companyId;
        private String nation;
        private String region;
        private String position;
        private int reward;
        private String description;
        private String skills;
    }

    @Data
    public static class UpdatePost { // 채용공고 수정
        private String nation;
        private String region;
        private String position;
        private int reward;
        private String description;
        private String skills;
    }

    @Data
    public static class DeletePost { // 채용공고 삭제
        private int postId;
    }
}
