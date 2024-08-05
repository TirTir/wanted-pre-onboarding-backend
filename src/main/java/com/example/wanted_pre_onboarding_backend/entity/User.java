package com.example.wanted_pre_onboarding_backend.entity;

import com.example.wanted_pre_onboarding_backend.dto.RecruitPostRequest;
import com.example.wanted_pre_onboarding_backend.dto.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter @Builder
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", unique = true, nullable = false)
    private int userId;

    @Column(name = "userName", length = 50, nullable = false)
    private String userName;

    @ManyToOne
    @JoinColumn(name = "postId")
    private RecruitPost recruitPost;

    public void updateRecruitPost(RecruitPost request) {
        this.recruitPost = recruitPost;
    }
}
