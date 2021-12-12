package com.project.tharun.CompanyServiceApplication.controller;

import com.project.tharun.CompanyServiceApplication.DTO.IpoDTO;
import com.project.tharun.CompanyServiceApplication.exception.IPONotFoundException;
import com.project.tharun.CompanyServiceApplication.service.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ipo")
public class IPOController {
    @Autowired
    private IPOService ipoService;

    @GetMapping("")
    public ResponseEntity<List<IpoDTO>> getIPOs()
    {
        return ResponseEntity.ok(ipoService.findALl());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<IpoDTO> findIPOById(@PathVariable String id) throws IPONotFoundException
    {
        return ResponseEntity.ok(ipoService.findById(id));
    }

    @PostMapping(path="")
    public ResponseEntity<IpoDTO> addIPO(@RequestBody IpoDTO ipoDTO)
    {
        return ResponseEntity.ok(ipoService.addIPO(ipoDTO));
    }

    @PutMapping(path="")
    public ResponseEntity<IpoDTO> editIPO(@RequestBody IpoDTO ipoDTO) throws IPONotFoundException
    {
        return ResponseEntity.ok(ipoService.editIPO(ipoDTO));
    }

    @DeleteMapping(path="/{id}")
    public void deleteIPOById(@PathVariable  String id)
    {
        ipoService.deleteIPOById(id);
    }
}
