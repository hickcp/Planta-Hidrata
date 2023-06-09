package com.api.rega.dto.plantainfo;

import com.api.rega.entity.PlantaInformacoes;

public record DadosDetalhamentoInformacoes(Long id, Long idPlanta, float luzSolar, float umidade, float temperatura) {
    public DadosDetalhamentoInformacoes(PlantaInformacoes informacoes){
        this(informacoes.getId(), informacoes.getPlanta().getId(), informacoes.getLuzSolar(), informacoes.getUmidade(), informacoes.getTemperatura());
    }
}
