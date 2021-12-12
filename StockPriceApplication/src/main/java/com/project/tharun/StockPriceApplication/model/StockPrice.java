package com.project.tharun.StockPriceApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "StockPrice")
public class StockPrice {
    @Id
    private String id;
    private String companyCode;
    private String stockExchange;
    private String currentPrice;
    private String date;
    private String time;

}
