package com.smp.client.service;

import com.smp.client.model.Company;
import com.smp.client.repository.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    private Company findCompanyById(Long id) {

        return repository.findCompanyById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compania não encontrada pelo id: " + id));
    }

    public Company getRandomCompany() {
        long totalCompanies = repository.count();
        if (totalCompanies == 0) {
            throw new EntityNotFoundException("Nenhuma compania encontrada no banco de dados.");
        }

        int randomId = new Random().nextInt((int) totalCompanies) + 1;

        return findCompanyById((long) randomId);
    }

}
