package com.project.tharun.CompanyServiceApplication.DAO;

import com.project.tharun.CompanyServiceApplication.DTO.CompanyDTO;
import com.project.tharun.CompanyServiceApplication.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends MongoRepository<Company,String> {
    public Company findByCompanyName(String companyName);
    public List<Company> findByCompanyNameIgnoreCaseContaining(String pattern);
}
