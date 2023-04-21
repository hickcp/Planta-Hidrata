package com.api.rega.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "plantas")
@Entity(name = "Planta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Planta {

    private Long id;
    private String nome;
    private String nomeCientifico;

    @OneToMany(mappedBy = "id_planta")
    private PlantaInformacoes informacoes;
}
