package com.example.wanted_pre_onboarding_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table (name = "recruitPost")
@NoArgsConstructor
@AllArgsConstructor
public class RecruitPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId", unique = true, nullable = false)
    private int postId; // 채용공고 id

    @Column(name = "companyId", nullable = false)
    private int companyId; // 회사 id

    @Column(name = "companyName", length = 100, nullable = false)
    private String companyName; // 회사명

    @Column(name = "nation", length = 100, nullable = false)
    private String nation; // 국가

    @Column(name = "region", length = 100, nullable = false)
    private String region; // 지역

    @Column(name = "position", length = 100, nullable = false)
    private String position; // 채용포지션

    @Column(name = "reward", nullable = false)
    private int reward; // 채용보상금

    @Column(name = "description", length = 300)
    private String description; // 채용 내용

    @Column(name = "skills", length = 100)
    private String skills; // 사용기술
}
