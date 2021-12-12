package com.project.tharun.StockExchangeApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Company")
public class Company {
    @Id
    @JsonProperty("Id")
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
