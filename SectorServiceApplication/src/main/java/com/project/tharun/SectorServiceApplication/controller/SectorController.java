package com.project.tharun.SectorServiceApplication.controller;

import com.project.tharun.SectorServiceApplication.DTO.CompanyDTO;
import com.project.tharun.SectorServiceApplication.DTO.SectorDTO;
import com.project.tharun.SectorServiceApplication.Exception.SectorNotFoundException;
import com.project.tharun.SectorServiceApplication.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/sectors")
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @GetMapping(path = "")
    public ResponseEntity<List<SectorDTO>> getSectors()
    {
        return ResponseEntity.ok(sectorService.getSectors());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SectorDTO>  getSectorById(@PathVariable String id)  throws SectorNotFoundException
    {
        return ResponseEntity.ok(sectorService.getSectorBYId(id));
    }

    @PostMapping(path = "")
    public ResponseEntity<SectorDTO> addSector(@RequestBody SectorDTO sectorDTO)
    {
        return ResponseEntity.ok(sectorService.addSector(sectorDTO));
    }

    @PutMapping(path = "")
    public ResponseEntity<SectorDTO> editSector(@RequestBody SectorDTO sectorDTO)
            throws SectorNotFoundException
    {
        return ResponseEntity.ok(sectorService.editSector(sectorDTO));
    }
    @DeleteMapping(path = "/{id}")
    public void deleteSectorById(@PathVariable String id)
    {
        sectorService.deleteSectorById(id);
    }

    @GetMapping(path = "/{sectorName}/companies")
    public List<CompanyDTO> getCompanies(@PathVariable String sectorName)
            throws SectorNotFoundException
    {
        return sectorService.getCompanies(sectorName);
    }

    @PostMapping(path = "/{sectorName}/companies")
    public void addCompanyToSector(@PathVariable String sectorName,@RequestBody CompanyDTO companyDTO)
            throws SectorNotFoundException
    {
        sectorService.addCompanyToSector(sectorName,companyDTO);
    }
}
