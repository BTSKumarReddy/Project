package com.project.tharun.CompanyServiceApplication.Mapper;

import com.project.tharun.CompanyServiceApplication.DTO.IpoDTO;
import com.project.tharun.CompanyServiceApplication.model.Ipo;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class IPOMapper {

    public Ipo toIPO(IpoDTO ipoDTO)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Ipo ipo=modelMapper.map(ipoDTO, Ipo.class);
        return ipo;
    }
    public IpoDTO toIPODTO(Ipo ipo)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        IpoDTO ipoDTO=modelMapper.map(ipo, IpoDTO.class);
        return ipoDTO;
    }
    public List<IpoDTO> toIPODTOs(List<Ipo> ipo)
    {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<IpoDTO> ipoDTOS = Arrays.asList(modelMapper.map(ipo, IpoDTO[].class));
        return ipoDTOS;
    }

}
