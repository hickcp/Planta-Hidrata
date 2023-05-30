package com.api.rega.dto.planta;

import com.api.rega.entity.Planta;

public record DadosPlantaNome(Long id,String nome) {
    public DadosPlantaNome(Planta planta){
        this(planta.getId(), planta.getNome());
    }
}
