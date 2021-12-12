package com.project.tharun.CompanyServiceApplication.service;

import com.project.tharun.CompanyServiceApplication.DAO.IPORepository;
import com.project.tharun.CompanyServiceApplication.DTO.IpoDTO;
import com.project.tharun.CompanyServiceApplication.Mapper.IPOMapper;
import com.project.tharun.CompanyServiceApplication.exception.IPONotFoundException;
import com.project.tharun.CompanyServiceApplication.model.Ipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPOServiceImpl implements IPOService{
    @Autowired
    private IPORepository ipoRepository;

    @Autowired
    private IPOMapper ipoMapper;

    @Override
    public List<IpoDTO> findALl() {
        return ipoMapper.toIPODTOs(ipoRepository.findAll());
    }

    @Override
    public IpoDTO findById(String id) {
        Optional <Ipo> ipo =ipoRepository.findById(id);
        if(!(ipo.isPresent()))
        {
            throw new IPONotFoundException("There is no IPO with id : "+id);
        }
        return ipoMapper.toIPODTO(ipo.get());
    }

    @Override
    public IpoDTO addIPO(IpoDTO ipoDTO) {

        return ipoMapper.toIPODTO(ipoRepository.save(ipoMapper.toIPO(ipoDTO)));
    }

    @Override
    public IpoDTO editIPO(IpoDTO ipoDTO) {
        if(!(ipoRepository.findById(ipoDTO.getId()).isPresent()))
        {
            throw new IPONotFoundException("Unable to edit because no IPO found with id : "+ipoDTO.getId());
        }
        ipoRepository.save(ipoMapper.toIPO(ipoDTO));
        return ipoDTO;
    }

    @Override
    public void deleteIPOById(String id) {
        ipoRepository.deleteById(id);
    }
}
