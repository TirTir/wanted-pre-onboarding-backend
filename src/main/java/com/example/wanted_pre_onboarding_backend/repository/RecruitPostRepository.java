package com.example.wanted_pre_onboarding_backend.repository;

import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitPostRepository extends JpaRepository<RecruitPost, Integer> {
    List<RecruitPost> findAll();
}
