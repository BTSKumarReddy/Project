package com.project.tharun.StockPriceApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDTO {
    private String id;
    private String companyCode;
    private String stockExchange;
    private String currentPrice;
    private String date;
    private String time;
}
