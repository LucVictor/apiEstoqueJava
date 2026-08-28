package com.caico.estoque.controller;

import com.caico.estoque.dto.usuario.UsuarioLoginDTO;
import com.caico.estoque.dto.usuario.UsuarioDTO;
import com.caico.estoque.dto.usuario.UsuarioRegistroDTO;
import com.caico.estoque.service.AutenticacaoService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;

    public AutenticacaoController(
            AutenticacaoService autenticacaoService
    ) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(
            @RequestBody UsuarioLoginDTO request
    ) {

        UsuarioDTO response =
                autenticacaoService.login(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/registro")
    public ResponseEntity<Void> registrar(
            @RequestBody UsuarioRegistroDTO request
    ) {

        autenticacaoService.registrar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}