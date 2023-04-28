package com.api.rega.dto;

import com.api.rega.entity.Planta;
import com.api.rega.entity.PlantaInformacoes;

public record DadosDetalhamentoPlantaEInformacoes(Long id, String nome, String nomeCientifico, PlantaInformacoes informacoes) {
    public DadosDetalhamentoPlantaEInformacoes(Planta planta) {
        this(planta.getId(), planta.getNome(), planta.getNomeCientifico(), planta.getInformacoes().get(planta.getInformacoes().size() - 1));
    }
}
