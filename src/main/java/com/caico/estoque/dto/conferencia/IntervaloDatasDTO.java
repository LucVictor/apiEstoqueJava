package com.caico.estoque.dto.conferencia;

import java.time.LocalDate;

public record IntervaloDatasDTO(
        LocalDate dataInicio, // Sexta-feira
        LocalDate dataFim     // Quinta-feira
) {}