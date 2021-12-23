package com.project.tharun.StockExchangeApplication.Initializer;

import com.project.tharun.StockExchangeApplication.DAO.StockExchangeRepository;
import com.project.tharun.StockExchangeApplication.model.StockExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockExchangeInitializer implements CommandLineRunner {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Override
    public void run(String... args) throws Exception
    {
        stockExchangeRepository.deleteAll();
        StockExchange bse =new StockExchange("BSE", "Bombay Stock Exchange",  "World's 10th largest stock-exchange","Dalal Street, Mumbai, India","1992 scam");
        stockExchangeRepository.save(bse);
        StockExchange nse =new StockExchange("NSE", "National Stock Exchange",  "India's 4th largest stock-exchange","Mumbai, India","2008 satyam scam");
        stockExchangeRepository.save(nse);
    }
}
