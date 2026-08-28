package com.caico.estoque.controller;


import com.caico.estoque.dto.avaria.AvariaCadastroDTO;
import com.caico.estoque.model.Avaria;
import com.caico.estoque.repository.AvariaRepository;
import com.caico.estoque.service.AvariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaria")
public class AvariaController {
    private final AvariaService avariaService;

    public AvariaController(AvariaRepository avariaRepository, AvariaService avariaService) {
        this.avariaService = avariaService;
    }


    @GetMapping("/listar")
    public List<Avaria> listar(){
        return avariaService.listarTodos();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Avaria> cadastrar(@RequestBody AvariaCadastroDTO avaria){

        Avaria novaAvaria = avariaService.cadastrar(avaria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAvaria);

    }

    @DeleteMapping ("/deletar/{id}")
    public ResponseEntity<Avaria> deletar(@PathVariable Long id){

        Avaria avaria = avariaService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK).body(avaria);

    }

    @GetMapping("/relatorio/{dataInicial}/{dataFinal}/{filial}")
    public List<Avaria> relatorio(@PathVariable String dataInicial, @PathVariable String dataFinal, @PathVariable(required = false) Optional<Integer> filial){
        return avariaService.relatorio(dataInicial, dataFinal, filial);
    }
}
