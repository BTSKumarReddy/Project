package com.project.tharun.CompanyServiceApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpoDTO {

    private String id;
    private String companyName;
    private String stockExchange;
    private double  pricePerShare;
    private long totalNumberOfShares;
    private String openDateTime;
    private String remarks;

}
