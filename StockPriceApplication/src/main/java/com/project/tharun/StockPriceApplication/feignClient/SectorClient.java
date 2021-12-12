package com.project.tharun.StockPriceApplication.feignClient;

import com.project.tharun.StockPriceApplication.DTO.CompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "Sector-Service")
public interface SectorClient {

    @GetMapping(path = "/sectors/{sectorName}/companies")
    public List<CompanyDTO> getCompanies(@PathVariable String sectorName);

}
