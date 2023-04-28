package com.api.rega.dto.planta;

import com.api.rega.dto.plantainfo.PlantaInfoDTO;
import com.api.rega.entity.Planta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PlantaDTO {

    private Long id_planta;
    private String nome;
    private String nome_cientifico;
    private List<PlantaInfoDTO> informacoes;

    public PlantaDTO() {}

    public PlantaDTO(Planta planta, List<PlantaInfoDTO> infos) {
        this.id_planta = planta.getId();
        this.nome = planta.getNome();
        this.nome_cientifico = planta.getNomeCientifico();
        this.informacoes = infos;
    }
}
