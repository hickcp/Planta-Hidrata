package com.api.rega.dto;

import com.api.rega.entity.Planta;
import com.api.rega.entity.PlantaInformacoes;

public record DadosDetalhamentoPlanta(Long id, String nome, String nomeCientifico, float umidade, float luzSolar, float temperatura, boolean regar) {
    public DadosDetalhamentoPlanta(Planta planta, PlantaInformacoes informacoes){
        this(planta.getId(), planta.getNome(), planta.getNomeCientifico(), informacoes.getUmidade(), informacoes.getLuzSolar(),
                informacoes.getTemperatura(), informacoes.isRegar());
    }
}
