package com.example.wanted_pre_onboarding_backend.repository;

import com.example.wanted_pre_onboarding_backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
}
