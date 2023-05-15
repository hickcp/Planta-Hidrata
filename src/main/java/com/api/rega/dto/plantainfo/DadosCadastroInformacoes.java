package com.api.rega.dto.plantainfo;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroInformacoes(

        @NotNull
        Long idPlanta,

        @NotNull
        float luzSolar,

        @NotNull
        float umidade,

        @NotNull
        float temperatura


) {
}
