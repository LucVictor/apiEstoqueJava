package com.caico.estoque.service;
import com.caico.estoque.dto.avaria.AvariaCadastroDTO;
import com.caico.estoque.model.Avaria;
import com.caico.estoque.model.Produto;
import com.caico.estoque.repository.AvariaRepository;
import com.caico.estoque.repository.ProdutoRepository;
import com.caico.estoque.security.UsuarioAutenticado;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AvariaService {
    private final AvariaRepository avariaRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioAutenticado usuarioAutenticado;

    public AvariaService(AvariaRepository avariaRepository, ProdutoRepository produtoRepository, UsuarioAutenticado usuarioAutenticado) {
        this.avariaRepository = avariaRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioAutenticado = usuarioAutenticado;
    }


    public List<Avaria> listarTodos() {
        return avariaRepository.findAll();
    }

    @Transactional
    public Avaria excluir(Long id){
        Avaria avaria = avariaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Avaria não encontrada id:" + id));
        avariaRepository.delete(avaria);
        return avaria;
    }

    public List<Avaria> relatorio(String dataInicio, String dataFinal, Optional<Integer> filial){
        LocalDate dataInicial = LocalDate.parse(dataInicio);
        LocalDate dataTermino = LocalDate.parse(dataFinal);
        Optional<Integer> idFilial = filial;

        List<Avaria> listagem = avariaRepository.findByDataBetween(dataInicial, dataTermino).stream().filter(avaria ->
                filial == null ||
                        avaria.getFilial().equals(idFilial)).toList();
        return listagem;
    }

    @Transactional
    public Avaria cadastrar(AvariaCadastroDTO avaria) {
        Long codigoProduto = avaria.codigoProduto();
        Produto produto = produtoRepository.findByCodigo(codigoProduto)
                .orElseThrow(() -> new IllegalArgumentException("Código de produto não encontrado: " + codigoProduto));
        Double custoTotal = produto.getCusto() * avaria.quantidade();
        Avaria novaAvaria = new Avaria(
                produto.getCodigo(),
                produto.getNome(),
                avaria.quantidade(),
                custoTotal,
                avaria.observacoes(),
                usuarioAutenticado.getFilial(),
                null,
                usuarioAutenticado.getUsuario(),
                LocalDate.now()
        );
        return avariaRepository.save(novaAvaria);
    }
}
