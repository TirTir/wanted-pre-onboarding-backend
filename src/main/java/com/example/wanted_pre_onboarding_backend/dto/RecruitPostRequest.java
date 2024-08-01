package com.example.wanted_pre_onboarding_backend.dto;

import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
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

    public RecruitPost toEntity(){
        return RecruitPost.builder()
                .companyId(companyId)
                .companyName(companyName)
                .nation(nation)
                .region(region)
                .position(position)
                .reward(reward)
                .description(description)
                .skills(skills)
                .build();
    }
}
