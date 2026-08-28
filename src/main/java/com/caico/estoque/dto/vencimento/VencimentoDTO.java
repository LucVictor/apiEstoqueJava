package com.caico.estoque.dto.vencimento;

import java.time.LocalDate;

public record VencimentoDTO(
        Long codigoProduto,
        Double quantidade,
        String lote,
        String filial,
        String usuario,
        LocalDate dataVencimento
) {}