package com.project.tharun.StockExchangeApplication.DAO;

import com.project.tharun.StockExchangeApplication.DTO.StockExchangeDTO;
import com.project.tharun.StockExchangeApplication.model.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockExchangeRepository extends MongoRepository<StockExchange, String> {
 StockExchange findByName(String stockExchangeName);
}
