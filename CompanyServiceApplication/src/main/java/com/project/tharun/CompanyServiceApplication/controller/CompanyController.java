package com.project.tharun.CompanyServiceApplication.controller;

import com.project.tharun.CompanyServiceApplication.DTO.CompanyDTO;
import com.project.tharun.CompanyServiceApplication.DTO.IpoDTO;
import com.project.tharun.CompanyServiceApplication.exception.CompanyNotFoundException;
import com.project.tharun.CompanyServiceApplication.service.CompanyService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping(path="")
    public ResponseEntity<List<CompanyDTO>> getCompanies()
    {
        return ResponseEntity.ok(companyService.getCompanies());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<CompanyDTO> getCompanyDetails(@PathVariable("id") String id) throws CompanyNotFoundException
    {
        CompanyDTO companyDTO=companyService.findById(id);
        return ResponseEntity.ok(companyDTO);
    }

    @GetMapping(path = "/match/{pattern}")
    public ResponseEntity<List<CompanyDTO>> getMatchingCompanies(@PathVariable String pattern)
    {
        return ResponseEntity.ok(companyService.getMatchingCompanies(pattern));
    }

    @GetMapping(path = "/{id}/ipos")
    public ResponseEntity<List<IpoDTO>> getCompanyTpoDetails(@PathVariable String id)
            throws CompanyNotFoundException
    {
        return ResponseEntity.ok(companyService.getCompanyIpoDetails(id));
    }

    @PostMapping(path = "/{companyName}/ipos")
    public void addIpoCompany(@PathVariable String companyName ,@RequestBody IpoDTO ipoDTO)
            throws CompanyNotFoundException
    {
        companyService.addIpoToCompany(companyName,ipoDTO);
    }

    @PostMapping(path="")
    @CircuitBreaker(name="CompanyCircuitBreaker",fallbackMethod = "defaultResponse")
    public ResponseEntity<?> addCompany(@RequestBody CompanyDTO companyDTO)
    {
        return ResponseEntity.ok(companyService.addCompany(companyDTO));
    }

    @PutMapping(path="")
    public ResponseEntity<CompanyDTO> editCompany(@RequestBody CompanyDTO companyDTO)
            throws CompanyNotFoundException
    {
        CompanyDTO updatedCompanyDTO=companyService.editCompany(companyDTO);
        return ResponseEntity.ok(updatedCompanyDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCompany(@PathVariable String id){
        companyService.deleteCompany(id);
    }

     public ResponseEntity<?> defaultResponse(Exception e){
        String errorMessage = "StockExchange Application microservice is down"+e.toString();
         return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorMessage);
     }
}
