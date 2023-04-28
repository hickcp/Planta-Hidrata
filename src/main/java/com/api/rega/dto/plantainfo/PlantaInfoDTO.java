package com.api.rega.dto.plantainfo;

import com.api.rega.dto.planta.PlantaDTO;
import com.api.rega.entity.PlantaInformacoes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PlantaInfoDTO {

    private PlantaDTO planta;
    private Long id_planta_info;
    private Float luz_solar;
    private Float umidade;
    private Float temperatura;
    private Boolean regar;

    public PlantaInfoDTO() {}

    public PlantaInfoDTO(PlantaInformacoes plantaInfo) {
        this.planta = new PlantaDTO(plantaInfo.getPlanta());
        this.id_planta_info = plantaInfo.getId();
        this.luz_solar = plantaInfo.getLuzSolar();
        this.umidade = plantaInfo.getUmidade();
        this.temperatura = plantaInfo.getTemperatura();
        this.regar = plantaInfo.isRegar();
    }
}
