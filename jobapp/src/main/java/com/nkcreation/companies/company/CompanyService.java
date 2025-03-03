package com.nkcreation.companies.company;

import com.nkcreation.jobapp.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> findAll();
    void createCompany(Company company);
    Company findById(Long id);
    boolean deleteCompany(Long id);
    boolean updateCompany(Long id, Company job);
}
