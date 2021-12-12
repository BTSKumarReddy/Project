package com.project.tharun.StockExchangeApplication.Mapper;

import com.project.tharun.StockExchangeApplication.DTO.CompanyDTO;
import com.project.tharun.StockExchangeApplication.model.Company;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CompanyMapper {
    public CompanyDTO toCompanyDTO(Company company)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompanyDTO companyDTO=modelMapper.map(company,CompanyDTO.class);
        return companyDTO;
    }
    public Company toCompany(CompanyDTO companyDTO)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Company company=modelMapper.map(companyDTO,Company.class);
        return company;
    }
    public List<CompanyDTO> toCompanyDTOs(List<Company> company)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<CompanyDTO> companyDTOs= Arrays.asList(modelMapper.map(company,CompanyDTO[].class));
        return companyDTOs;
    }

}
