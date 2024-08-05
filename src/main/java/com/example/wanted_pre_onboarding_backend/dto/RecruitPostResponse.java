package com.example.wanted_pre_onboarding_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class RecruitPostResponse {

    @Data
    @AllArgsConstructor
    public static class Post { // 채용공고
        private int postId;
        private String companyName;
        private String nation;
        private String region;
        private String position;
        private int reward;
        private String skills;
    }

    @Data
    @AllArgsConstructor
    public static class DetailPost { // 채용공고 상세
        private int postId;
        private String companyName;
        private String nation;
        private String region;
        private String position;
        private int reward;
        private String description;
        private String skills;
        private List<Long> otherRecruitPosts;
    }
}
