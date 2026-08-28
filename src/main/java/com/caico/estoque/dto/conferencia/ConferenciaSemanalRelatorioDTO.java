package com.caico.estoque.dto.conferencia;

import java.util.List;

public record ConferenciaSemanalRelatorioDTO(
        String usuario,
        List<ConferenciaSemanalDTO> dados
) {
}