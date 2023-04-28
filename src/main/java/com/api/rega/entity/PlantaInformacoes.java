package com.api.rega.entity;

import com.api.rega.dto.DadosCadastroInformacoes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="planta_informacoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlantaInformacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_planta", nullable = false)
    private Planta planta;

    @Column(name = "luz_solar", nullable = false)
    private float luzSolar;

    @Column(name = "umidade", nullable = false)
    private float umidade;

    @Column(name = "temperatura", nullable = false)
    private float temperatura;

    @Column(name = "regar", nullable = false)
    private boolean regar;

    public PlantaInformacoes(DadosCadastroInformacoes dados) {
        this.planta = new Planta(dados.idPlanta());
        this.luzSolar = dados.luzSolar();
        this.umidade = dados.umidade();
        this.temperatura = dados.temperatura();
    }
}
