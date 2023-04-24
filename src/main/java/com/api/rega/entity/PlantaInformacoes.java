package com.api.rega.entity;

import com.api.rega.dto.DadosCadastroInformacoes;
import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long idPlanta;

    float luzSolar;
    float umidade;
    float temperatura;
    boolean regar;

    public PlantaInformacoes(DadosCadastroInformacoes dados) {
        this.idPlanta = dados.idPlanta();
        this.luzSolar = dados.luzSolar();
        this.umidade = dados.umidade();
        this.temperatura = dados.temperatura();
    }
}
