package com.project.tharun.StockPriceApplication.Mapper;

import com.project.tharun.StockPriceApplication.DTO.StockPriceDTO;
import com.project.tharun.StockPriceApplication.model.StockPrice;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StockPriceMapper {

    public StockPrice toStockPrice(StockPriceDTO stockPriceDTO)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StockPrice stockPrice=modelMapper.map(stockPriceDTO,StockPrice.class);
        return stockPrice;
    }
    public StockPriceDTO toStockPriceDTO(StockPrice stockPrice)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StockPriceDTO stockPriceDTO=modelMapper.map(stockPrice,StockPriceDTO.class);
        return stockPriceDTO;
    }
    public List<StockPriceDTO> toStockPriceDTOs(List<StockPrice> stockPrice)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<StockPriceDTO> stockPriceDTO= Arrays.asList(modelMapper.map(stockPrice,StockPriceDTO[].class));
        return stockPriceDTO;
    }
    public List<StockPrice> toStockPrices(List<StockPriceDTO> stockPriceDTO)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<StockPrice> stockPrice= Arrays.asList(modelMapper.map(stockPriceDTO,StockPrice[].class));
        return stockPrice;
    }
}
