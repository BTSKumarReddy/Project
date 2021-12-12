package com.project.tharun.SectorServiceApplication.Mapper;

import com.project.tharun.SectorServiceApplication.DTO.SectorDTO;
import com.project.tharun.SectorServiceApplication.model.Sector;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SectorMapper {

    public Sector toSector(SectorDTO sectorDTO)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Sector sector=modelMapper.map(sectorDTO,Sector.class);
        return sector;
    }

    public SectorDTO toSectorDTO(Sector sector)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        SectorDTO sectorDTO=modelMapper.map(sector,SectorDTO.class);
        return sectorDTO;
    }

    public List<SectorDTO> toSectorDTOs(List<Sector> sector)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<SectorDTO> sectorDTO= Arrays.asList(modelMapper.map(sector,SectorDTO[].class));
        return sectorDTO;
    }

}
