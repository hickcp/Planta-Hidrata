package com.api.rega.service;

import com.api.rega.dto.planta.DadosPlantaNome;
import com.api.rega.dto.plantainfo.PlantaInfoDTO;
import com.api.rega.entity.Planta;
import com.api.rega.repository.PlantaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaService {

    @Autowired
    PlantaRepository repository;

    public List<DadosPlantaNome> getNomes(){
       List<Planta> plantas = repository.findAll();
       if(plantas.isEmpty()){
           throw new EntityNotFoundException("Não há registro de plantas!");
       }
        List<DadosPlantaNome> infos = plantas.stream().map(p -> new DadosPlantaNome(p)).toList();
       return infos;
    }
}
