package com.project.tharun.SectorServiceApplication.service;

import com.project.tharun.SectorServiceApplication.DAO.SectorRepository;
import com.project.tharun.SectorServiceApplication.DTO.CompanyDTO;
import com.project.tharun.SectorServiceApplication.DTO.SectorDTO;
import com.project.tharun.SectorServiceApplication.Exception.SectorNotFoundException;
import com.project.tharun.SectorServiceApplication.Mapper.CompanyMapper;
import com.project.tharun.SectorServiceApplication.Mapper.SectorMapper;
import com.project.tharun.SectorServiceApplication.model.Company;
import com.project.tharun.SectorServiceApplication.model.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorServiceImpl implements SectorService{
    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private SectorMapper sectorMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public SectorDTO addSector(SectorDTO sectorDTO) {
        Sector sector=sectorRepository.save(sectorMapper.toSector(sectorDTO));
        return sectorMapper.toSectorDTO(sector);
    }

    @Override
    public SectorDTO editSector(SectorDTO sectorDTO) {
        if(!(sectorRepository.findById(sectorDTO.getId()).isPresent()))
        {
            throw new SectorNotFoundException("Unable to edit because there is no sector with id : "+sectorDTO.getId());
        }
        sectorRepository.save(sectorMapper.toSector(sectorDTO));
        return sectorDTO;
    }

    @Override
    public List<SectorDTO> getSectors() {
        return sectorMapper.toSectorDTOs(sectorRepository.findAll());
    }

    @Override
    public SectorDTO getSectorBYId(String id) {
        Optional<Sector> sector=sectorRepository.findById(id);
        if(!(sector.isPresent()))
        {
            throw new SectorNotFoundException("There is no Sector with id : "+id);
        }
        return sectorMapper.toSectorDTO(sector.get());
    }

    @Override
    public void deleteSectorById(String id) {
       sectorRepository.deleteById(id);
    }

    @Override
    public List<CompanyDTO> getCompanies(String sectorName) {
        Sector sector=sectorRepository.findByName(sectorName);
        if(sector==null)
        {
            throw new SectorNotFoundException("There is no sector with sectorName : "+sectorName);
        }

        return companyMapper.toCompanyDTOs(sector.getCompanies());
    }

    @Override
    public SectorDTO addCompanyToSector(String sectorName, CompanyDTO companyDTO) {
        Sector sector=sectorRepository.findByName(sectorName);
        if(sector==null)
        {
            throw new SectorNotFoundException("There is no Sector with sectorName : "+sectorName);
        }
        Company company=companyMapper.toCompany(companyDTO);
        sector.getCompanies().add(company);
        sector=sectorRepository.save(sector);
        return sectorMapper.toSectorDTO(sector);
    }
}
