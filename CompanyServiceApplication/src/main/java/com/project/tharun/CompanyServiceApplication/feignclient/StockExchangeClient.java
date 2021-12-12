package com.project.tharun.CompanyServiceApplication.feignclient;

import com.project.tharun.CompanyServiceApplication.DTO.CompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "Stock-Exchange")
public interface StockExchangeClient {
    @PostMapping(path = "/stockExchanges/{stockExchangeName}/companies")
    public void addCompanyToStockExchange(@PathVariable String stockExchangeName, @RequestBody CompanyDTO companyDTO);
}
