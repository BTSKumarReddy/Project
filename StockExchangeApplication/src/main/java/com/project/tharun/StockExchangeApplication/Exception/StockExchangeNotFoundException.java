package com.project.tharun.StockExchangeApplication.Exception;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockExchangeNotFoundException extends RuntimeException{
    String message;
}
