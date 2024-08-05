package com.example.wanted_pre_onboarding_backend.service;

import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.entity.Company;
import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
import com.example.wanted_pre_onboarding_backend.exception.GeneralException;
import com.example.wanted_pre_onboarding_backend.repository.CompanyRepository;
import com.example.wanted_pre_onboarding_backend.repository.RecruitPostRepository;
import com.example.wanted_pre_onboarding_backend.response.status.ErrorCode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitPostService {
    private final RecruitPostRepository recruitPostRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public RecruitPostService(RecruitPostRepository recruitPostRepository, CompanyRepository companyRepository) {
        this.recruitPostRepository = recruitPostRepository;
        this.companyRepository = companyRepository;
    }

    @Transactional
    public List<RecruitPost> getRecruitPosts(){
        return recruitPostRepository.findAll();
    }

    @Transactional
    public void register(RecruitPostRequest.RegisterPost request) {
        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new GeneralException(ErrorCode.NOT_EXIST_COMPANY));

        RecruitPost newRecruitPost = RecruitPost.builder()
                .company(company)
                .nation(request.getNation())
                .region(request.getRegion())
                .position(request.getPosition())
                .reward(request.getReward())
                .description(request.getDescription())
                .skills(request.getSkills())
                .build();

        recruitPostRepository.save(newRecruitPost);
    }

    @Transactional
    public void update(int postId, RecruitPostRequest.UpdatePost request) {
        RecruitPost recruitPost = recruitPostRepository.findById(postId)
                        .orElseThrow(() -> new GeneralException(ErrorCode.NOT_EXIST_POST));

        recruitPost.updateRecruitPost(request);
    }

    @Transactional
    public void delete(RecruitPostRequest.DeletePost request) {
        RecruitPost recruitPost = recruitPostRepository.findById(request.getPostId())
                .orElseThrow(() -> new GeneralException(ErrorCode.NOT_EXIST_POST));

        recruitPostRepository.delete(recruitPost);
    }
}
