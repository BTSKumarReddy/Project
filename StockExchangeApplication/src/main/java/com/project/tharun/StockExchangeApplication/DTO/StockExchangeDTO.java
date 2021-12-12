package com.project.tharun.StockExchangeApplication.DTO;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockExchangeDTO {
    private String Id;
    private String name;
    private String Brief;
    private String Contact_Address;
    private String Remarks;
}
