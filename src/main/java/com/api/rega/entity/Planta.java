package com.api.rega.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="plantas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "nome_cientifico", nullable = false)
    private String nomeCientifico;

    @OneToMany(mappedBy = "planta")
    private List<PlantaInformacoes> informacoes;

    public Planta(Long idPlanta) {
        this.id = idPlanta;
    }
}
