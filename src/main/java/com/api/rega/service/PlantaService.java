package com.api.rega.service;

import com.api.rega.dto.DadosDetalhamentoPlantaEInformacoes;
import com.api.rega.entity.Planta;
import com.api.rega.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantaService {

    @Autowired
    PlantaRepository repository;

    public DadosDetalhamentoPlantaEInformacoes plantaEInformacoes(Long id){
        var planta = repository.buscarPlantaeInformacoes(id);
        var detalhes = new DadosDetalhamentoPlantaEInformacoes(planta);
        return detalhes;
    }
}
