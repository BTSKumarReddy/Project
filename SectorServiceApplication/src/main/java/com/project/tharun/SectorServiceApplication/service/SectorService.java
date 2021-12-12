package com.project.tharun.SectorServiceApplication.service;

import com.project.tharun.SectorServiceApplication.DTO.CompanyDTO;
import com.project.tharun.SectorServiceApplication.DTO.SectorDTO;
import com.project.tharun.SectorServiceApplication.model.Company;

import java.util.List;

public interface SectorService {
 public SectorDTO addSector(SectorDTO sectorDTO);
 public SectorDTO editSector(SectorDTO sectorDTO);
 public List<SectorDTO> getSectors();
 public SectorDTO getSectorBYId(String id);
 public void deleteSectorById(String id);
 public List<CompanyDTO> getCompanies(String sectorName);
 public SectorDTO addCompanyToSector(String sectorName,CompanyDTO companyDTO);
}
