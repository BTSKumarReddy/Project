package com.project.tharun.StockExchangeApplication.service;

import com.project.tharun.StockExchangeApplication.DAO.StockExchangeRepository;
import com.project.tharun.StockExchangeApplication.DTO.CompanyDTO;
import com.project.tharun.StockExchangeApplication.DTO.StockExchangeDTO;
import com.project.tharun.StockExchangeApplication.Exception.StockExchangeNotFoundException;
import com.project.tharun.StockExchangeApplication.Mapper.CompanyMapper;
import com.project.tharun.StockExchangeApplication.Mapper.StockExchangeMapper;
import com.project.tharun.StockExchangeApplication.model.StockExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {
    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Autowired
    private StockExchangeMapper stockExchangeMapper;

    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public List<StockExchangeDTO> getStockExchangesList() {
        return stockExchangeMapper.toStockExchangeDTOS(stockExchangeRepository.findAll());
    }

    @Override
    public StockExchangeDTO findById(String id) {
        Optional<StockExchange> stockExchange=stockExchangeRepository.findById(id);
        if(!(stockExchange.isPresent()))
        {
            throw new StockExchangeNotFoundException("There is no StockExchange with id : "+id);
        }
        return stockExchangeMapper.toStockExchangeDTO(stockExchange.get());
    }

    @Override
    public StockExchangeDTO addStockExchange(StockExchangeDTO stockExchangeDTO) {
        return stockExchangeMapper.toStockExchangeDTO(stockExchangeRepository.save(stockExchangeMapper.toStockExchange(stockExchangeDTO)));
    }

    @Override
    public StockExchangeDTO editStockExchange(StockExchangeDTO stockExchangeDTO) {
        if(!(stockExchangeRepository.findById((stockExchangeDTO.getId())).isPresent()))
        {
            throw new StockExchangeNotFoundException("Unable to edit because there is no StockExchange with id : "+stockExchangeDTO.getId());
        }
        StockExchange stockExchange=stockExchangeRepository.save(stockExchangeMapper.toStockExchange(stockExchangeDTO));
        return stockExchangeMapper.toStockExchangeDTO(stockExchange);
    }

    @Override
    public void deleteStockExchange(String id) {
        stockExchangeRepository.deleteById(id);
    }

    @Override
    public List<CompanyDTO> getCompanies(String id) {
        Optional <StockExchange> stockExchange=stockExchangeRepository.findById(id);
        if(!(stockExchange.isPresent()))
        {
            throw new StockExchangeNotFoundException("There is no stockExchange with id : "+id);
        }

        return companyMapper.toCompanyDTOs(stockExchange.get().getCompanies());
    }

    @Override
    public StockExchangeDTO addCompanyToStockExchange(String stockExchangeName, CompanyDTO companyDTO) {
        StockExchange stockExchange =stockExchangeRepository.findByName(stockExchangeName);
        if(stockExchange==null)
        {
            throw new StockExchangeNotFoundException("There is no stockExchange with name : "+stockExchangeName);
        }
        stockExchange.getCompanies().add(companyMapper.toCompany(companyDTO));
        stockExchange=stockExchangeRepository.save(stockExchange);
        return stockExchangeMapper.toStockExchangeDTO(stockExchange);
    }

}
