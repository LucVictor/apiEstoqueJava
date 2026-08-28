package com.caico.estoque.service;

import com.caico.estoque.model.Produto;
import com.caico.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorCodigo(Long codigo) {
        return produtoRepository.findByCodigo(codigo).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o codigo: " + codigo));
    }

    public Produto buscarPorCodigoBarras(Long codigobarras) {
        return produtoRepository.findByCodigoBarras(codigobarras).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o codigo de barras: " + codigobarras));
    }

}