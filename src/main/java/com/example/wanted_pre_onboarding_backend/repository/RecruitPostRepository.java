package com.example.wanted_pre_onboarding_backend.repository;

import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecruitPostRepository extends JpaRepository<RecruitPost, Integer> {
    List<RecruitPost> findAll(); // 채용공고 전체 검색
    Optional<RecruitPost> findById(int id);
}
