package com.project.tharun.CompanyServiceApplication.service;

import com.project.tharun.CompanyServiceApplication.DAO.CompanyRepository;
import com.project.tharun.CompanyServiceApplication.DAO.IPORepository;
import com.project.tharun.CompanyServiceApplication.DTO.CompanyDTO;
import com.project.tharun.CompanyServiceApplication.DTO.IpoDTO;
import com.project.tharun.CompanyServiceApplication.Mapper.CompanyMapper;
import com.project.tharun.CompanyServiceApplication.Mapper.IPOMapper;
import com.project.tharun.CompanyServiceApplication.exception.CompanyNotFoundException;
import com.project.tharun.CompanyServiceApplication.feignclient.SectorClient;
import com.project.tharun.CompanyServiceApplication.feignclient.StockExchangeClient;
import com.project.tharun.CompanyServiceApplication.model.Company;
import com.project.tharun.CompanyServiceApplication.model.Ipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
     private CompanyRepository companyRepository;

    @Autowired
     private CompanyMapper companyMapper;

    @Autowired
    private IPOMapper ipoMapper;

    @Autowired
    private StockExchangeClient stockExchangeClient;

    @Autowired
    private SectorClient sectorClient;

    @Autowired
    private IPORepository ipoRepository;


    @Override
    public List<CompanyDTO> getCompanies() {

        return companyMapper.toCompanyDTOs(companyRepository.findAll());
    }

    @Override
    public List<CompanyDTO> getMatchingCompanies(String pattern) {
        List<Company> companies=companyRepository.findByCompanyNameIgnoreCaseContaining(pattern);
        return companyMapper.toCompanyDTOs(companies);
    }

    @Override
    public CompanyDTO findById(String id) {

        Optional<Company> company=companyRepository.findById(id);
        if(!(company.isPresent()))
        {
            throw new CompanyNotFoundException("Company no found at id : "+id);
        }
        return companyMapper.toCompanyDTO(company.get());
    }

    @Override
    public CompanyDTO addCompany(CompanyDTO companyDTO) {
        Company company=companyMapper.toCompany(companyDTO);
        sectorClient.addCompanyToSector(company.getSector(),companyDTO);
        String[] stockExchangeNames=company.getStockExchanges().split(",");
        for(String temp:stockExchangeNames)
        {
            stockExchangeClient.addCompanyToStockExchange(temp,companyDTO);
        }
        company.getIpos().add(ipoRepository.findByCompanyName(company.getCompanyName()));
        company=companyRepository.save(company);
        return companyDTO;
    }

    @Override
    public CompanyDTO editCompany(CompanyDTO companyDTO) {

        if(!(companyRepository.findById(companyDTO.getId()).isPresent()))
        {
                throw new CompanyNotFoundException("Unable to edit since company not found with id : "+companyDTO.getId());
        }
        Company updatedCompany=companyRepository.save(companyMapper.toCompany(companyDTO));
        return companyMapper.toCompanyDTO(updatedCompany);
    }

    @Override
    public void deleteCompany(String id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<IpoDTO> getCompanyIpoDetails(String id) {
        Optional<Company> company=companyRepository.findById(id);
        if(!(company.isPresent()))
        {
            throw new CompanyNotFoundException("There is no company listed in stockExchange with id : "+id+" please check in ipo's tab");

        }
        List<Ipo> ipos=company.get().getIpos();
        return ipoMapper.toIPODTOs(ipos);
    }

    @Override
    public CompanyDTO addIpoToCompany(String companyName, IpoDTO ipoDTO) {
        Company company=companyRepository.findByCompanyName(companyName);
        if(company==null)
        {
            throw new CompanyNotFoundException("There is no company with companyName : "+companyName);
        }
        Ipo ipo=ipoMapper.toIPO(ipoDTO);
        company.getIpos().add(ipo);
        company=companyRepository.save(company);
        return companyMapper.toCompanyDTO(company);
    }

}
