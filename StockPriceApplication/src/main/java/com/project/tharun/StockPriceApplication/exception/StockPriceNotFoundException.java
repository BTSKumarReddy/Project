package com.project.tharun.StockPriceApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceNotFoundException extends RuntimeException{
    private String message;
}
