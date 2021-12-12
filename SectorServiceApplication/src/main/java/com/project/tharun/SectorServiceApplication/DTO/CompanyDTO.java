package com.project.tharun.SectorServiceApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    private String id;
    private String companyName;
    private float turnover;
    private String ceo;
    private String board_Of_Directors;
    private String stockExchanges;
    private String sector;
    private String brief;
    private String code;
}
