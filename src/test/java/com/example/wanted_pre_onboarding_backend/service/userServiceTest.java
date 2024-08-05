package com.example.wanted_pre_onboarding_backend.service;

import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.dto.UserRequest;
import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
import com.example.wanted_pre_onboarding_backend.entity.User;
import com.example.wanted_pre_onboarding_backend.repository.RecruitPostRepository;
import com.example.wanted_pre_onboarding_backend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class userServiceTest {
    @Autowired
    private UserService userService;
    private RecruitPostService recruitPostService;
    @Autowired
    private UserRepository userRepository;
    private RecruitPostRepository recruitPostRepository;

    private int postId;

    @BeforeEach
    public void setUp() {
        // 데이터베이스 초기화
        userRepository.deleteAll();

        RecruitPostRequest.RegisterPost requestDto = new RecruitPostRequest.RegisterPost();
        requestDto.setCompanyId(1);
        requestDto.setNation("한국");
        requestDto.setRegion("서울");
        requestDto.setPosition("백엔드 개발자");
        requestDto.setReward(100000);
        requestDto.setDescription("test description");
        requestDto.setSkills("Java, Spring");

        recruitPostService.register(requestDto);
        postId = recruitPostRepository.findAll().get(0).getPostId();
    }

    @Test
    @DisplayName("채용 공고 지원")
    void registerTest() {
        // given
        UserRequest.ApplyPost requestDto = new UserRequest.ApplyPost();
        requestDto.setUserId(1);
        requestDto.setPostId(postId);

        // when
        userService.apply(requestDto);

        // then
        User user = userRepository.findById(1).get();
        RecruitPost recruitPost = recruitPostRepository.findById(postId).get();

        assertThat(user.getUserId()).isEqualTo(1);
        assertThat(user.getRecruitPost()).isEqualTo(recruitPost);
    }
}
