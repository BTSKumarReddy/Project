package com.project.tharun.CompanyServiceApplication.service;

import com.project.tharun.CompanyServiceApplication.DTO.CompanyDTO;
import com.project.tharun.CompanyServiceApplication.DTO.IpoDTO;
import com.project.tharun.CompanyServiceApplication.model.Ipo;

import java.util.List;

public interface CompanyService {
    public List<CompanyDTO> getCompanies();
    public List<CompanyDTO> getMatchingCompanies(String pattern);
    public CompanyDTO findById(String id);
    public CompanyDTO addCompany(CompanyDTO companyDTO);
    public CompanyDTO editCompany(CompanyDTO companyDTO);
    public void deleteCompany(String company_Code);
    public List<IpoDTO> getCompanyIpoDetails(String id);
    public CompanyDTO addIpoToCompany(String companyName, IpoDTO ipoDTO);


}
