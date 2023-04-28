package com.api.rega.service;

import com.api.rega.dto.DadosCadastroInformacoes;
import com.api.rega.dto.DadosDetalhamentoInformacoes;
import com.api.rega.dto.DadosListagemInformacoes;
import com.api.rega.dto.plantainfo.PlantaInfoDTO;
import com.api.rega.entity.PlantaInformacoes;
import com.api.rega.repository.PlantaInformacoesRepository;
import com.api.rega.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantaInformacoesService {

    @Autowired
    private PlantaInformacoesRepository plantaInfoRepo;

    @Autowired
    private PlantaRepository plantaRepo;

    public DadosDetalhamentoInformacoes cadastrar(DadosCadastroInformacoes dados){

        var informacoes = new PlantaInformacoes(dados);

        plantaInfoRepo.save(informacoes);

        return new DadosDetalhamentoInformacoes(informacoes);
    }

    public List<DadosListagemInformacoes> listar(){
        var informacoes = plantaInfoRepo.findAll().stream().map(DadosListagemInformacoes::new).toList();

        return informacoes;
    }

    public PlantaInfoDTO ultimoCadastrado() {
        Long ultimaPlantaId = plantaRepo.ultimaPlantaCadastrada();
        Optional<PlantaInformacoes> plantaInfo = plantaInfoRepo.getByIdPlanta(ultimaPlantaId);
        if (plantaInfo.isEmpty()) {
            return new PlantaInfoDTO();
        }

        return new PlantaInfoDTO(plantaInfo.get());
    }
}
