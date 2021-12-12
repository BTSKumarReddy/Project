package com.project.tharun.StockExchangeApplication.Mapper;


import com.project.tharun.StockExchangeApplication.DTO.StockExchangeDTO;
import com.project.tharun.StockExchangeApplication.model.StockExchange;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StockExchangeMapper {
    public StockExchangeDTO  toStockExchangeDTO(StockExchange stockExchange)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StockExchangeDTO stockExchangeDTO=modelMapper.map(stockExchange,StockExchangeDTO.class);
        return stockExchangeDTO;

    }
    public StockExchange toStockExchange(StockExchangeDTO stockExchangeDTO)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StockExchange stockExchange=modelMapper.map(stockExchangeDTO,StockExchange.class);
        return stockExchange;
    }
    public List<StockExchangeDTO>  toStockExchangeDTOS(List<StockExchange> stockExchanges)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<StockExchangeDTO> stockExchangeDTOS= Arrays.asList(modelMapper.map(stockExchanges,StockExchangeDTO[].class));
        return stockExchangeDTOS;
    }

}
