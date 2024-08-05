package com.example.wanted_pre_onboarding_backend.service;

import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
import com.example.wanted_pre_onboarding_backend.repository.RecruitPostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class recruitPostServiceTest {
    @Autowired
    private RecruitPostService recruitPostService;
    @Autowired
    private RecruitPostRepository recruitPostRepository;

    private int postId;

    @BeforeEach
    void setUp() {
        // 데이터베이스 초기화
        recruitPostRepository.deleteAll();

        // 테스트를 시작 할 때 마다 새로 생성
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
    @DisplayName("채용 공고 등록")
    void registerTest() {
        // given
        RecruitPostRequest.RegisterPost requestDto = new RecruitPostRequest.RegisterPost();
        requestDto.setCompanyId(2);
        requestDto.setNation("한국");
        requestDto.setRegion("서울");
        requestDto.setPosition("백엔드 개발자");
        requestDto.setReward(100000);
        requestDto.setDescription("test description");
        requestDto.setSkills("Java, Spring");

        // when
       recruitPostService.register(requestDto);

        // then
        assertThat(recruitPostRepository.count()).isEqualTo(2);
    }

    @Test
    @DisplayName("채용 공고 수정")
    void updateTest() {
        // given
        RecruitPostRequest.UpdatePost updateRequest = new RecruitPostRequest.UpdatePost();
        updateRequest.setPosition("시니어 개발자");
        updateRequest.setReward(200000);
        updateRequest.setDescription("updated description");
        updateRequest.setSkills("Python, Django");

        // when
        recruitPostService.update(postId, updateRequest);

        //then
        RecruitPost recruitPost = recruitPostRepository.findById(postId).get();

        assertThat(recruitPost.getNation()).isEqualTo("한국");
        assertThat(recruitPost.getRegion()).isEqualTo("서울");
        assertThat(recruitPost.getPosition()).isEqualTo("시니어 개발자");
        assertThat(recruitPost.getReward()).isEqualTo(200000);
        assertThat(recruitPost.getDescription()).isEqualTo("updated description");
        assertThat(recruitPost.getSkills()).isEqualTo("Python, Django");
    }

    @Test
    @DisplayName("채용 공고 삭제")
    void deleteTest() {
        // given
        RecruitPostRequest.DeletePost deleteRequest = new RecruitPostRequest.DeletePost();
        deleteRequest.setPostId(postId);

        // when
        recruitPostService.delete(deleteRequest);

        // then
        assertThat(recruitPostRepository.findById(postId)).isEmpty();
    }
}
