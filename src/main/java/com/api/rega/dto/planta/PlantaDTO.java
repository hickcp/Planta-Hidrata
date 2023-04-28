package com.api.rega.dto.planta;

import com.api.rega.entity.Planta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PlantaDTO {

    private Long id_planta;
    private String nome;
    private String nome_cientifico;

    public PlantaDTO() {}

    public PlantaDTO(Planta planta) {
        this.id_planta = planta.getId();
        this.nome = planta.getNome();
        this.nome_cientifico = planta.getNomeCientifico();
    }
}
