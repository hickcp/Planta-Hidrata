package com.api.rega.service;

import com.api.rega.dto.plantainfo.DadosCadastroInformacoes;
import com.api.rega.dto.plantainfo.DadosDetalhamentoInformacoes;
import com.api.rega.dto.plantainfo.DadosDetalhamentoPlanta;
import com.api.rega.dto.plantainfo.DadosListagemInformacoes;
import com.api.rega.dto.planta.PlantaDTO;
import com.api.rega.dto.plantainfo.DadosCadastroRegar;
import com.api.rega.dto.plantainfo.PlantaInfoDTO;
import com.api.rega.entity.Planta;
import com.api.rega.entity.PlantaInformacoes;
import com.api.rega.repository.PlantaInformacoesRepository;
import com.api.rega.repository.PlantaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
        if(informacoes.isEmpty()){
            throw new EntityNotFoundException();
        }
        return informacoes;
    }

    public PlantaDTO getInfoByPlantaId(Long plantaId, int limite) {
        Optional<Planta> planta = plantaRepo.findById(plantaId);

        PageRequest page = PageRequest.of(0, limite);
        List<PlantaInformacoes> plantaInfos = plantaInfoRepo.getInfoByPlantaId(plantaId, page);
        if (plantaInfos.isEmpty() || planta.isEmpty()) {
            throw new EntityNotFoundException();
        }

        List<PlantaInfoDTO> infos = plantaInfos.stream().map(p -> new PlantaInfoDTO(p)).toList();
        return new PlantaDTO(planta.get(), infos);
    }

    public DadosDetalhamentoPlanta regar(Long plantaId, DadosCadastroRegar dados){
        PlantaInformacoes informacoes = plantaInfoRepo.getLastInfoId(plantaId);
        if (informacoes == null){
            throw new EntityNotFoundException();
        }
        informacoes.setRegar(dados.regar());
        PlantaInformacoes newInfo = plantaInfoRepo.save(informacoes);
        Planta planta = plantaRepo.getReferenceById(plantaId);

        return new DadosDetalhamentoPlanta(planta, informacoes);
    }
}
