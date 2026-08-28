package com.caico.estoque.dto.conferencia;

public record ConferenciaCadastroDTO(
        Long codigoProduto,
        Double quantidadeSistema,
        Double quantidadeFisico
) {
}
