package com.project.tharun.StockExchangeApplication.controller;

import com.project.tharun.StockExchangeApplication.DTO.CompanyDTO;
import com.project.tharun.StockExchangeApplication.DTO.StockExchangeDTO;

import com.project.tharun.StockExchangeApplication.Exception.StockExchangeNotFoundException;
import com.project.tharun.StockExchangeApplication.service.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/stockExchanges")
public class StockExchangeController {
    @Autowired
    private StockExchangeService stockExchangeService;

    @GetMapping(path="")
    public ResponseEntity<List<StockExchangeDTO>> getStockExchangesList()
    {
           return ResponseEntity.ok(stockExchangeService.getStockExchangesList());
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<StockExchangeDTO> getStockExchangeDetails(@PathVariable String id)
            throws StockExchangeNotFoundException
    {
        return ResponseEntity.ok(stockExchangeService.findById(id));
    }
    @PostMapping(path="")
    public ResponseEntity<StockExchangeDTO> addStockExchange(@RequestBody StockExchangeDTO stockExchangeDTO)
    {
        return ResponseEntity.ok(stockExchangeService.addStockExchange(stockExchangeDTO));
    }
    @PutMapping(path="")
    public ResponseEntity<StockExchangeDTO> editStockExchange(@RequestBody StockExchangeDTO stockExchangeDTO)
            throws StockExchangeNotFoundException
    {
        return ResponseEntity.ok(stockExchangeService.editStockExchange(stockExchangeDTO));
    }
    @DeleteMapping(path="/{id}")
    public void deleteStockExchange(@PathVariable String id)
    {
        stockExchangeService.deleteStockExchange(id);
    }

    @GetMapping(path = "/{id}/companies")
    public ResponseEntity<List<CompanyDTO>> getCompanies(@PathVariable String id)
            throws StockExchangeNotFoundException
    {
        return ResponseEntity.ok(stockExchangeService.getCompanies(id));
    }

    @PostMapping(path = "/{stockExchangeName}/companies")
    public void addCompanyToStockExchange(@PathVariable String stockExchangeName,@RequestBody CompanyDTO companyDTO)
            throws StockExchangeNotFoundException
    {
         stockExchangeService.addCompanyToStockExchange(stockExchangeName,companyDTO);
    }

}
