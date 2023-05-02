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
    private Long id;

    private float luzSolar;
    private float umidade;
    private float temperatura;
    private boolean regar;


    @ManyToOne
    @JoinColumn(name = "id_planta")
    private Planta planta;

    public PlantaInformacoes(DadosCadastroInformacoes dados) {
        this.luzSolar = dados.luzSolar();
        this.umidade = dados.umidade();
        this.temperatura = dados.temperatura();
    }
}
