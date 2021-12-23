package com.project.tharun.StockExchangeApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="StockExchange")
public class StockExchange {
    @Id
    @JsonProperty("Id")
    private String id;
    private String name;
    private String brief;
    private String contact_Address;
    private String remarks;
    @DBRef
    private List<Company> companies=new ArrayList<>();

    public StockExchange(String id, String name, String brief, String contact_Address, String remarks) {
        this.id = id;
        this.name = name;
        this.brief = brief;
        this.contact_Address = contact_Address;
        this.remarks = remarks;
    }
}
