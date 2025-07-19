package com.smp.client.repository;

import com.smp.client.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyById(Long id);

}
