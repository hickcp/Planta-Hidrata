package com.api.rega.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "plantaInformacoes")
@Entity(name = "PlantaInformacoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PlantaInformacoes {
    Long id;
    Long id_planta;
    float luzSolar;
    float umidade;
    float temperatura;
    boolean regar;
}
