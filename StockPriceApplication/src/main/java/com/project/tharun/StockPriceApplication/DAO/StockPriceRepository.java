package com.project.tharun.StockPriceApplication.DAO;

import com.project.tharun.StockPriceApplication.model.StockPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPriceRepository extends MongoRepository<StockPrice,String> {
    public List<StockPrice>  findByCompanyCodeAndStockExchange(String companyCode,String stockExchange);
}
