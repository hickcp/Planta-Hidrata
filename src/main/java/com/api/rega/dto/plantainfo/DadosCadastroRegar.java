package com.api.rega.dto.plantainfo;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroRegar(
        @NotNull
        Boolean regar
) {
}
