package com.nkcreation.companies.impl;


import com.nkcreation.companies.company.Company;
import com.nkcreation.companies.company.CompanyRepository;
import com.nkcreation.companies.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CompanyImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    public void createCompany(Company company){

        companyRepository.save(company);
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company findById(Long id){

        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return  true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteById(Long id){
        try {

            companyRepository.deleteById(id);
            return true;
        }catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }

    public boolean updateCompany(Long id,Company company) {

        try {
            Optional<Company> optionalCompany = companyRepository.findById(id);

            if (optionalCompany.isPresent()) {

                var com = optionalCompany.get();

                com.setCompanyName(company.getCompanyName());
                com.setCompanyDescription(com.getCompanyDescription());
                if (company.getJobs() != null || company.getJobs().isEmpty()) {

                    com.setJobs(company.getJobs());
                }

                companyRepository.save(com);

                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
