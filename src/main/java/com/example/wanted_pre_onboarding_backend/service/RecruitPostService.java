package com.example.wanted_pre_onboarding_backend.service;

import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
import com.example.wanted_pre_onboarding_backend.repository.RecruitPostRepository;
import com.example.wanted_pre_onboarding_backend.response.CommonResponse;
import com.example.wanted_pre_onboarding_backend.response.ResponseMessage;
import com.example.wanted_pre_onboarding_backend.response.StatusCode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruitPostService {
    private final RecruitPostRepository recruitPostRepository;

    @Autowired
    public RecruitPostService(RecruitPostRepository recruitPostRepository) {
        this.recruitPostRepository = recruitPostRepository;
    }

    @Transactional
    public void register(RecruitPostRequest request) {
        RecruitPost newRecruitPost = request.toEntity();
        recruitPostRepository.save(newRecruitPost);
    }
}
