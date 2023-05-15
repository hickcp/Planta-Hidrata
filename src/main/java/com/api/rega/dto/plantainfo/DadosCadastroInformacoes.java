package com.api.rega.dto.plantainfo;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroInformacoes(

        @NotNull
        Long idPlanta,

        @NotNull
        Float luzSolar,

        @NotNull
        Float umidade,

        @NotNull
        Float temperatura


) {
}
