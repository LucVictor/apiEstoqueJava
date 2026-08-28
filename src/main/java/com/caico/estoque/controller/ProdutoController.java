package com.caico.estoque.controller;
import com.caico.estoque.model.Produto;
import com.caico.estoque.service.ProdutoService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/buscarcodigo/{codigo}")
    public Produto buscarPorCodigo(@PathVariable Long codigo) {
        return produtoService.buscarPorCodigo(codigo);
    }

    @GetMapping("/buscarbarras/{barras}")
    public Produto buscarPorCodigoBarras(@PathVariable Long barras) {
        return produtoService.buscarPorCodigoBarras(barras);
    }
}