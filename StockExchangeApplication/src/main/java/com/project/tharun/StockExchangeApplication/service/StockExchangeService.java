package com.project.tharun.StockExchangeApplication.service;

import com.project.tharun.StockExchangeApplication.DTO.CompanyDTO;
import com.project.tharun.StockExchangeApplication.DTO.StockExchangeDTO;
import com.project.tharun.StockExchangeApplication.model.StockExchange;

import java.util.List;

public interface StockExchangeService {
     List<StockExchangeDTO> getStockExchangesList();
    StockExchangeDTO findById(String id);
     StockExchangeDTO addStockExchange(StockExchangeDTO stockExchangeDTO);
     StockExchangeDTO editStockExchange(StockExchangeDTO stockExchangeDTO);
     void deleteStockExchange(String id);
     List<CompanyDTO> getCompanies(String id);
     StockExchangeDTO addCompanyToStockExchange(String stockExchangeName, CompanyDTO companyDTO);

}
