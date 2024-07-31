package com.example.wanted_pre_onboarding_backend.service;

import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
import com.example.wanted_pre_onboarding_backend.repository.RecruitPostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RecruitPostService {
    @Autowired
    private RecruitPostRepository recruitPostRepository;

    @Transactional
    public void register(RecruitPostRequest request) throws Exception {
        try{
            RecruitPost newRecruitPost = request.toEntity();
            recruitPostRepository.save(newRecruitPost);
        } catch (Exception e){
            throw new Exception("공고 등록에 실패하였습니다.");
        }

    }

}
