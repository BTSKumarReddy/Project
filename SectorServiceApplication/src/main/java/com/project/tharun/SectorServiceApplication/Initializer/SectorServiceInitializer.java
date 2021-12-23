package com.project.tharun.SectorServiceApplication.Initializer;

import com.project.tharun.SectorServiceApplication.DAO.SectorRepository;
import com.project.tharun.SectorServiceApplication.model.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SectorServiceInitializer implements CommandLineRunner
{
    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public void run(String... args) throws Exception
    {
        sectorRepository.deleteAll();
        Sector sector1 = new Sector("Fin1","Finance", "Companies that assist in Finance and Accounting");
        sectorRepository.save(sector1);
        Sector sector2 = new Sector("Hel1","Healthcare Services", "Companies that provide Healthcare Services");
        sectorRepository.save(sector2);
        Sector sector3 = new Sector("Pha1","Pharmaceuticals", "Companies that provide Medicines");
        sectorRepository.save(sector3);
        Sector sector4 = new Sector("Hot1","Hostels", "Companies that provide with accomodation services");
        sectorRepository.save(sector4);
        Sector sector5 = new Sector("IntS1","Internet Software and Services", "Companies that provide internet facilites as well as services");
        sectorRepository.save(sector5);
    }

}
