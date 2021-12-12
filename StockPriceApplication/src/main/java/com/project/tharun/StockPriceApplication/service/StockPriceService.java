package com.project.tharun.StockPriceApplication.service;

import com.project.tharun.StockPriceApplication.DTO.StockPriceDTO;
import com.project.tharun.StockPriceApplication.Request.CompanyCompareRequest;
import com.project.tharun.StockPriceApplication.Request.SectorCompareRequest;

import java.text.ParseException;
import java.util.List;

public interface StockPriceService {

    public List<StockPriceDTO> getStockPrices();
    public StockPriceDTO getStockPriceById(String id);
    public StockPriceDTO editStockPrice(StockPriceDTO stockPriceDTO);
    public List<StockPriceDTO> addStockPrice(List<StockPriceDTO> stockPriceDTOS);
    public void deleteStockPriceById(String id);
    public List<StockPriceDTO> getStockPricesForCompanyComparison(CompanyCompareRequest companyCompareRequest) throws ParseException;
    public List<StockPriceDTO> getStockPricesForSectorComparison(SectorCompareRequest sectorCompareRequest) throws ParseException;
}
