package com.project.tharun.StockPriceApplication.service;

import com.project.tharun.StockPriceApplication.DAO.StockPriceRepository;
import com.project.tharun.StockPriceApplication.DTO.CompanyDTO;
import com.project.tharun.StockPriceApplication.DTO.StockPriceDTO;
import com.project.tharun.StockPriceApplication.Mapper.StockPriceMapper;
import com.project.tharun.StockPriceApplication.Request.CompanyCompareRequest;
import com.project.tharun.StockPriceApplication.Request.SectorCompareRequest;
import com.project.tharun.StockPriceApplication.exception.StockPriceNotFoundException;
import com.project.tharun.StockPriceApplication.feignClient.SectorClient;
import com.project.tharun.StockPriceApplication.model.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockPriceServiceImpl implements StockPriceService{

    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Autowired
    private StockPriceMapper stockPriceMapper;

    @Autowired
    private SectorClient sectorClient;

    @Override
    public List<StockPriceDTO> getStockPrices() {
        return stockPriceMapper.toStockPriceDTOs(stockPriceRepository.findAll());
    }

    @Override
    public StockPriceDTO getStockPriceById(String id) {
        Optional<StockPrice> stockPrice=stockPriceRepository.findById(id);
        if(!(stockPrice.isPresent()))
        {
            throw new StockPriceNotFoundException("There is no StockPrice with id : "+id);
        }

        return stockPriceMapper.toStockPriceDTO(stockPrice.get());
    }

    @Override
    public StockPriceDTO editStockPrice(StockPriceDTO stockPriceDTO) {
        if(!(stockPriceRepository.findById(stockPriceDTO.getId()).isPresent()))
        {
            throw new StockPriceNotFoundException("Unable to edit because there is no StockPrice with id : "+stockPriceDTO.getId());
        }
        stockPriceRepository.save(stockPriceMapper.toStockPrice(stockPriceDTO));
        return stockPriceDTO;
    }

    @Override
    public List<StockPriceDTO> addStockPrice(List<StockPriceDTO> stockPriceDTOS) {
        List<StockPrice> stockPrice=stockPriceMapper.toStockPrices(stockPriceDTOS);
        stockPriceRepository.saveAll(stockPrice);
        return stockPriceDTOS;
    }

    @Override
    public void deleteStockPriceById(String id) {
        stockPriceRepository.deleteById(id);
    }

    @Override
    public List<StockPriceDTO> getStockPricesForCompanyComparison(CompanyCompareRequest companyCompareRequest) throws ParseException {
        Date fromDate =new SimpleDateFormat("dd-MM-yyyy").parse(companyCompareRequest.getFromPeriod());
        Date toDate=new SimpleDateFormat("dd-MM-yyyy").parse(companyCompareRequest.getToPeriod());
        List<StockPrice> stockPrices=stockPriceRepository.findByCompanyCodeAndStockExchange(companyCompareRequest.getCompanyCode(),companyCompareRequest.getStockExchangeName());
//        List<StockPrice>  filteredList =stockPrices.stream().filter(stockPrice -> {
//            Date date=null;
//            try {
//                date=new SimpleDateFormat("dd-MM-yyyy").parse(stockPrice.getDate());
//            }
//            catch (ParseException e) {
//                e.printStackTrace();
//            }
//            return date.after(fromDate) && date.before(toDate);
//        }).collect(Collectors.toList());
        return stockPriceMapper.toStockPriceDTOs(stockPrices);
    }

    @Override
    public List<StockPriceDTO> getStockPricesForSectorComparison(SectorCompareRequest sectorCompareRequest) throws ParseException {

        Date fromDate =new SimpleDateFormat("dd/MM/yyyy").parse(sectorCompareRequest.getFromPeriod());
        Date toDate=new SimpleDateFormat("dd/MM/yyyy").parse(sectorCompareRequest.getToPeriod());
        List<StockPrice> stockPricesForSector=new ArrayList<>();
        for(CompanyDTO companyDTO:sectorClient.getCompanies(sectorCompareRequest.getSectorName()))
        {
            List<StockPrice> stockPrices=stockPriceRepository.findByCompanyCodeAndStockExchange(companyDTO.getCode(),sectorCompareRequest.getStockExchangeName());
            List<StockPrice>  filteredList =stockPrices.stream().filter(stockPrice -> {
                Date date=null;
                try {
                    date=new SimpleDateFormat("dd/MM/yyyy").parse(stockPrice.getDate());
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                return date.after(fromDate) && date.before(toDate);
            }).collect(Collectors.toList());
            stockPricesForSector.addAll(filteredList);
        }
        return stockPriceMapper.toStockPriceDTOs(stockPricesForSector);
    }
}
