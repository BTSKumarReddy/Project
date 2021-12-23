package com.project.tharun.CompanyServiceApplication.DAO;

import com.project.tharun.CompanyServiceApplication.model.Ipo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPORepository extends MongoRepository<Ipo,String> {
    public Ipo findByCompanyName(String companyName);
}
