package com.api.rega.dto;

import com.api.rega.entity.PlantaInformacoes;

public record DadosListagemInformacoes(Long id, Long idPlanta, float luzSolar, float umidade, float temperatura) {
    public DadosListagemInformacoes(PlantaInformacoes informacoes){
        this(informacoes.getId(), informacoes.getIdPlanta(), informacoes.getLuzSolar(), informacoes.getUmidade(), informacoes.getTemperatura());
    }
}
