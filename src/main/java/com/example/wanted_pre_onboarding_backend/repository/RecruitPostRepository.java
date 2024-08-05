package com.example.wanted_pre_onboarding_backend.repository;

import com.example.wanted_pre_onboarding_backend.entity.RecruitPost;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruitPostRepository extends JpaRepository<RecruitPost, Integer> {
    @Query("SELECT p.postId FROM RecruitPost p WHERE p.company.companyId = :companyId AND p.postId <> :postId")
    List<Long> findOtherPostIdsByCompanyId(@Param("companyId") int companyId, @Param("postId") int postId);

    @Query("SELECT r FROM RecruitPost r JOIN r.company c WHERE " +
            "LOWER(r.position) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(r.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(r.skills) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(c.companyName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<RecruitPost> searchByKeyword(@Param("keyword") String keyword);
}
