package com.example.wanted_pre_onboarding_backend.service;

import com.example.wanted_pre_onboarding_backend.dto.UserRequest;
import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
import com.example.wanted_pre_onboarding_backend.entity.User;
import com.example.wanted_pre_onboarding_backend.exception.GeneralException;
import com.example.wanted_pre_onboarding_backend.repository.RecruitPostRepository;
import com.example.wanted_pre_onboarding_backend.repository.UserRepository;
import com.example.wanted_pre_onboarding_backend.response.status.ErrorCode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final RecruitPostRepository recruitPostRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserService(RecruitPostRepository recruitPostRepository, UserRepository userRepository) {
        this.recruitPostRepository = recruitPostRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void apply(UserRequest.ApplyPost request){
        // 유저 조회
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new GeneralException(ErrorCode.NOT_EXIST_USER));

        // 채용공고 조회
        RecruitPost recruitPost = recruitPostRepository.findById(request.getPostId())
                .orElseThrow(() -> new GeneralException(ErrorCode.NOT_EXIST_POST));

        user.updateRecruitPost(recruitPost);
        userRepository.save(user);
    }


}
