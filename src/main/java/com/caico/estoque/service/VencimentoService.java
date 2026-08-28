package com.caico.estoque.service;
import com.caico.estoque.dto.vencimento.VencimentoDTO;
import com.caico.estoque.model.Produto;
import com.caico.estoque.model.Vencimento;
import com.caico.estoque.repository.ProdutoRepository;
import com.caico.estoque.repository.VencimentoRepository;
import com.caico.estoque.security.UsuarioAutenticado;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class VencimentoService {
    private final VencimentoRepository vencimentoRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioAutenticado usuarioAutenticado;

    public VencimentoService(VencimentoRepository vencimentoRepository, ProdutoRepository produtoRepository, UsuarioAutenticado usuarioAutenticado) {
        this.vencimentoRepository = vencimentoRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public List<Vencimento> listarTodos() {
        return vencimentoRepository.findAll();
    }

    @Transactional
    public Vencimento editar(Long id, Double quantidade){
        Vencimento vencimento = vencimentoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Vencimento não encontrado com o id: " + id));
        vencimento.setQuantidade(quantidade);
        vencimento.setUsuario(usuarioAutenticado.getUsuario());
        return vencimentoRepository.save(vencimento);
    }

    @Transactional
    public Vencimento cadastrar(VencimentoDTO vencimento) {
        Long codigoProduto = vencimento.codigoProduto();
        Produto produto = produtoRepository.findByCodigo(codigoProduto)
                .orElseThrow(() -> new IllegalArgumentException("Código de produto não encontrado: " + codigoProduto));
        Vencimento novoVencimento = new Vencimento(
                produto.getCodigo(),
                produto.getNome(),
                vencimento.quantidade(),
                vencimento.lote(),
                usuarioAutenticado.getFilial(),
                usuarioAutenticado.getUsuario(),
                vencimento.dataVencimento()
        );
        return vencimentoRepository.save(novoVencimento);
    }
}
