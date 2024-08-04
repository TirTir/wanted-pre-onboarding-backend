package com.example.wanted_pre_onboarding_backend.repository;

import com.example.wanted_pre_onboarding_backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
    Optional<Company> findCompanyByCompanyId(int companyId);
}
