package com.example.wanted_pre_onboarding_backend.entity;

import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Builder
@Table (name = "recruitPost")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class RecruitPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId", unique = true, nullable = false)
    private int postId; // 채용공고 id

    @Column(name = "nation", length = 100, nullable = false)
    private String nation; // 국가

    @Column(name = "region", length = 100, nullable = false)
    private String region; // 지역

    @Column(name = "position", length = 100, nullable = false)
    private String position; // 채용포지션

    @Column(name = "reward", nullable = false)
    private int reward; // 채용보상금

    @Column(name = "description", length = 300,  nullable = false)
    private String description; // 채용 내용

    @Column(name = "skills", length = 100,  nullable = false)
    private String skills; // 사용기술

    @ManyToOne
    @JoinColumn(name = "companyId")
    @JsonBackReference
    private Company company;

    @OneToMany(mappedBy = "recruitPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public void updateRecruitPost(RecruitPostRequest.UpdatePost request) {
        if (request.getNation() != null) this.nation = request.getNation();
        if (request.getRegion() != null) this.region = request.getRegion();
        if (request.getPosition() != null) this.position = request.getPosition();
        if (request.getReward() != 0) this.reward = request.getReward();
        if (request.getDescription() != null) this.description = request.getDescription();
        if (request.getSkills() != null) this.skills = request.getSkills();
    }
}
