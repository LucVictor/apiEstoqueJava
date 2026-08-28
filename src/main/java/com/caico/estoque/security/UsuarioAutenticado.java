package com.caico.estoque.security;

import com.caico.estoque.model.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAutenticado {

    public Usuario get() {
        return (Usuario) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    public String getUsuario() {
        return get().getUsuario();
    }

    public String getNome() {
        return get().getNome();
    }

    public Integer getFilial() {
        return get().getFilial();
    }

    public Long getId() {
        return get().getId();
    }
}