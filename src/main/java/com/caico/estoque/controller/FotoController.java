package com.caico.estoque.controller;


import com.caico.estoque.service.FotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/foto")
public class FotoController {
    private final FotoService fotoService;
    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @PostMapping("/")
    public ResponseEntity<?> uploadFoto(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Arquivo inválido.");
        }
            ResponseEntity<?> nova_foto = fotoService.salvar(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(nova_foto);
    }
}