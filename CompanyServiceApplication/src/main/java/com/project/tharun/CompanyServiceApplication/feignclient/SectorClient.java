package com.project.tharun.CompanyServiceApplication.feignclient;

import com.project.tharun.CompanyServiceApplication.DTO.CompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "Sector-Service")
public interface SectorClient {
    @PostMapping(path = "/sectors/{sectorName}/companies")
    public void addCompanyToSector(@PathVariable String sectorName, @RequestBody CompanyDTO companyDTO);
}
