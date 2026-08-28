package com.caico.estoque.dto.avaria;

public record AvariaCadastroDTO(
        Long codigoProduto,
        Double quantidade,
        Integer tipoAvaria,
        Integer origemAvaria,
        String observacoes
) {
}
