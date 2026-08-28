package com.caico.estoque.controller;
import com.caico.estoque.dto.vencimento.VencimentoDTO;
import com.caico.estoque.dto.vencimento.VencimentoEditarDTO;
import com.caico.estoque.model.Vencimento;
import com.caico.estoque.service.VencimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vencimentos")
public class VencimentosController {

    private final VencimentoService vencimentoService;

    public VencimentosController(VencimentoService vencimentoService) {
        this.vencimentoService = vencimentoService;
    }

    @ResponseBody
    @GetMapping("/listar")
    public List<Vencimento> listarVencimentos() {
        return vencimentoService.listarTodos();
    }

    @ResponseBody
    @PostMapping("/cadastrar")
    public ResponseEntity<Vencimento> cadastrarVencimento(@RequestBody VencimentoDTO vencimento) {
        Vencimento novoVencimento = vencimentoService.cadastrar(vencimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVencimento);
    }

    @ResponseBody
    @PutMapping("/editar/{id}")
    public ResponseEntity<Vencimento> editarVencimento(@PathVariable Long id, @RequestBody VencimentoEditarDTO vencimento) {
        Vencimento vencimentoAtualizado = vencimentoService.editar(id, vencimento.quantidade());
        return ResponseEntity.status(HttpStatus.OK).body(vencimentoAtualizado);
    }
}
