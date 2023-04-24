package com.api.rega.service;

import com.api.rega.dto.DadosCadastroInformacoes;
import com.api.rega.dto.DadosDetalhamentoInformacoes;
import com.api.rega.entity.PlantaInformacoes;
import com.api.rega.repository.PlantaInformacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantaInformacoesService {

    @Autowired
    private PlantaInformacoesRepository repository;

    public DadosDetalhamentoInformacoes cadastrar(DadosCadastroInformacoes dados){

        var informacoes = new PlantaInformacoes(dados);

        repository.save(informacoes);

        return new DadosDetalhamentoInformacoes(informacoes);
    }
}
