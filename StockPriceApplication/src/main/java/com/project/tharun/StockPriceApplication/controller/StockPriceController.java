package com.project.tharun.StockPriceApplication.controller;

import com.project.tharun.StockPriceApplication.DTO.StockPriceDTO;
import com.project.tharun.StockPriceApplication.Request.CompanyCompareRequest;
import com.project.tharun.StockPriceApplication.Request.SectorCompareRequest;
import com.project.tharun.StockPriceApplication.exception.StockPriceNotFoundException;
import com.project.tharun.StockPriceApplication.service.StockPriceService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/stockPrices")
public class StockPriceController {

    @Autowired
    private StockPriceService stockPriceService;

    @GetMapping(path = "")
    public ResponseEntity<List<StockPriceDTO>> getStockPrices()
    {
        return ResponseEntity.ok(stockPriceService.getStockPrices());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StockPriceDTO> getStockPriceById(@PathVariable String id) throws StockPriceNotFoundException
    {
        return ResponseEntity.ok(stockPriceService.getStockPriceById(id));
    }

    @GetMapping(path = "/compareCompany")
    public ResponseEntity<?> companyComparison(@RequestBody CompanyCompareRequest companyCompareRequest)
    {
        List<StockPriceDTO> stockPriceDTOS=null;
        try {
            stockPriceDTOS=stockPriceService.getStockPricesForCompanyComparison(companyCompareRequest);
        }  catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Date Format");
        }
        return ResponseEntity.ok(stockPriceDTOS);
    }

    @GetMapping(path = "/compareSector")
    @CircuitBreaker(name="StockPriceCircuitBreaker",fallbackMethod = "defaultResponse")
    public ResponseEntity<?> sectorComparison(@RequestBody SectorCompareRequest sectorCompareRequest)
    {
        List<StockPriceDTO> stockPriceDTOS=null;
        try {
            stockPriceDTOS=stockPriceService.getStockPricesForSectorComparison(sectorCompareRequest);
        } catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Date format");
        }
        return ResponseEntity.ok(stockPriceService.addStockPrice(stockPriceDTOS));
    }
    @PostMapping(path = "")
    public ResponseEntity<List<StockPriceDTO>> addStockPrice(@RequestBody List<StockPriceDTO> stockPriceDTOs)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(stockPriceService.addStockPrice(stockPriceDTOs));
    }

    @PutMapping(path = "")
    public ResponseEntity<StockPriceDTO> editStockPrice(@RequestBody StockPriceDTO stockPriceDTO)
            throws StockPriceNotFoundException
    {
        return ResponseEntity.ok(stockPriceService.editStockPrice(stockPriceDTO));
    }
    @DeleteMapping(path = "/{id}")
    public void deleteStockPriceById(@PathVariable String id)
    {
        stockPriceService.deleteStockPriceById(id);
    }

    public ResponseEntity<?> defaultResponse(Exception e)
    {
        String errorMessage="Sector service Application microservice is down "+e.toString();
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorMessage);
    }
}
