package com.api.rega.service;

import com.api.rega.dto.DadosCadastroInformacoes;
import com.api.rega.dto.DadosDetalhamentoInformacoes;
import com.api.rega.dto.DadosListagemInformacoes;
import com.api.rega.entity.PlantaInformacoes;
import com.api.rega.repository.PlantaInformacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaInformacoesService {

    @Autowired
    private PlantaInformacoesRepository repository;

    public DadosDetalhamentoInformacoes cadastrar(DadosCadastroInformacoes dados){

        var informacoes = new PlantaInformacoes(dados);

        repository.save(informacoes);

        return new DadosDetalhamentoInformacoes(informacoes);
    }

    public List<DadosListagemInformacoes> listar(){
        var informacoes = repository.findAll().stream().map(DadosListagemInformacoes::new).toList();

        return informacoes;
    }
}
