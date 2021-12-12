package com.project.tharun.CompanyServiceApplication.DTO;

import lombok.*;

import javax.persistence.Column;

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
