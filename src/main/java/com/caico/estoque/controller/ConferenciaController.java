package com.caico.estoque.controller;

import com.caico.estoque.dto.conferencia.ConferenciaCadastroDTO;
import com.caico.estoque.dto.conferencia.ConferenciaSemanalRelatorioDTO;
import com.caico.estoque.model.Conferencia;
import com.caico.estoque.service.ConferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/conferencia")
public class ConferenciaController {
    private final ConferenciaService conferenciaService;

    public ConferenciaController(ConferenciaService conferenciaService) {
        this.conferenciaService = conferenciaService;
    }


    @GetMapping("/relatorio/{dataInicial}/{dataFinal}/")
    public List<Conferencia> relatorio(@PathVariable String dataInicial, @PathVariable String dataFinal){
        return conferenciaService.relatorio(dataInicial, dataFinal);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Conferencia> cadastrar(@RequestBody ConferenciaCadastroDTO conferencia){
        Conferencia novaConferencia = conferenciaService.cadastrar(conferencia);
        return ResponseEntity.status(HttpStatus.OK).body(novaConferencia);
    }

    @DeleteMapping ("/deletar/{id}")
    public ResponseEntity<Conferencia> deletar(@PathVariable Long id){
        Conferencia conferencia = conferenciaService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK).body(conferencia);

    }


    @GetMapping("/semanal/{semanas}/")
    public ResponseEntity<ConferenciaSemanalRelatorioDTO> semanal(@PathVariable Integer semanas){
        ConferenciaSemanalRelatorioDTO relatorio = conferenciaService.semanas(semanas);
        return ResponseEntity.status(HttpStatus.OK).body(relatorio);
    }

}
