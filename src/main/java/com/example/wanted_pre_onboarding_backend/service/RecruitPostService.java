package com.example.wanted_pre_onboarding_backend.service;

import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.dto.RecruitPostResponse;
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
import java.util.stream.Collectors;

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
    public List<RecruitPostResponse.Post> getList() {
        List<RecruitPost> recruitPosts = recruitPostRepository.findAll();

        return recruitPosts.stream()
                .map(dto -> new RecruitPostResponse.Post(
                        dto.getPostId(),
                        dto.getCompany().getCompanyName(),
                        dto.getNation(),
                        dto.getRegion(),
                        dto.getPosition(),
                        dto.getReward(),
                        dto.getSkills())
                ).collect(Collectors.toList());
    }

    @Transactional
    public RecruitPostResponse.DetailPost getDetail(int postId) {
        RecruitPost recruitPost = recruitPostRepository.findById(postId)
                .orElseThrow(() -> new GeneralException(ErrorCode.NOT_EXIST_POST));

        List<Long> otherRecruitPosts = recruitPostRepository.findOtherPostIdsByCompanyId(recruitPost.getCompany().getCompanyId(), postId);

        return new RecruitPostResponse.DetailPost(
                recruitPost.getPostId(),
                recruitPost.getCompany().getCompanyName(),
                recruitPost.getNation(),
                recruitPost.getRegion(),
                recruitPost.getPosition(),
                recruitPost.getReward(),
                recruitPost.getDescription(),
                recruitPost.getSkills(),
                otherRecruitPosts
        );
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
