package com.project.tharun.CompanyServiceApplication.service;

import com.project.tharun.CompanyServiceApplication.DTO.IpoDTO;

import java.util.List;

public interface IPOService {
    public List<IpoDTO> findALl();
    public IpoDTO findById(String id);
    public IpoDTO addIPO(IpoDTO ipoDTO);
    public IpoDTO editIPO(IpoDTO ipoDTO);
    public void deleteIPOById(String id);

}
