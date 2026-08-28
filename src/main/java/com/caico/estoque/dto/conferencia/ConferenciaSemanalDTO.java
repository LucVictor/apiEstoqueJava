package com.caico.estoque.dto.conferencia;

import java.time.LocalDate;

public record ConferenciaSemanalDTO (
        LocalDate inicioSemana,
        LocalDate finalSemana,
        Long conferenciasTotais
){
}
