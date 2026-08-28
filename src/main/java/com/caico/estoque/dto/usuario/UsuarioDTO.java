package com.caico.estoque.dto.usuario;

public record UsuarioDTO (
        String usuario,
        String nome,
        Integer filial,
        String token
){}
