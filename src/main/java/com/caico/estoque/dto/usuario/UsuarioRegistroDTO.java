package com.caico.estoque.dto.usuario;

import com.caico.estoque.model.Role;

public record UsuarioRegistroDTO (
        String usuario,
        String senha,
        String nome,
        Integer filial,
        Role role
) {
}