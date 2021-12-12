package com.project.tharun.CompanyServiceApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "IPOs_Planned")
public class Ipo {
    @Id
    @JsonProperty("Id")
    private String id;

    private String companyName;

    private double  pricePerShare;

    private long totalNumberOfShares;

    private String openDateTime;

    private String remarks;
}
