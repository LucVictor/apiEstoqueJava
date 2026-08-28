package com.caico.estoque.service;

import com.caico.estoque.dto.conferencia.ConferenciaCadastroDTO;

import com.caico.estoque.dto.conferencia.ConferenciaSemanalDTO;
import com.caico.estoque.dto.conferencia.ConferenciaSemanalRelatorioDTO;
import com.caico.estoque.dto.conferencia.IntervaloDatasDTO;
import com.caico.estoque.model.Conferencia;
import com.caico.estoque.model.Produto;
import com.caico.estoque.repository.ConferenciaRepository;
import com.caico.estoque.repository.ProdutoRepository;
import com.caico.estoque.security.UsuarioAutenticado;
import com.caico.estoque.utils.Conferencia.PeriodoUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenciaService {

    private final ConferenciaRepository conferenciaRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioAutenticado usuarioAutenticado;


    public ConferenciaService(ConferenciaRepository conferenciaRepository, ProdutoRepository produtoRepository, UsuarioAutenticado usuarioAutenticado) {
        this.conferenciaRepository = conferenciaRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioAutenticado = usuarioAutenticado;
    }

    @Transactional
    public Conferencia cadastrar(ConferenciaCadastroDTO conferencia){
        Long codigoProduto = conferencia.codigoProduto();
        Produto produto = produtoRepository.findByCodigo(codigoProduto)
                .orElseThrow(() -> new IllegalArgumentException("Código de produto não encontrado: " + codigoProduto));

        Conferencia novaConferencia = new Conferencia(produto.getCodigo(), produto.getNome(),
                conferencia.quantidadeFisico(), conferencia.quantidadeSistema(), usuarioAutenticado.getFilial(),
                usuarioAutenticado.getUsuario()
                );
        return conferenciaRepository.save(novaConferencia);
    }

    public List<Conferencia> relatorio(String dataInicio, String dataFinal){
        LocalDate dataInicial = LocalDate.parse(dataInicio);
        LocalDate dataTermino = LocalDate.parse(dataFinal);

        List<Conferencia> listagem = conferenciaRepository.findByDataBetween(dataInicial, dataTermino).stream().filter( conferencia ->
            conferencia.getUsuario().equals(usuarioAutenticado.getUsuario())).toList();
        return listagem;
    }

    public Conferencia excluir(Long id){
        Conferencia conferencia = conferenciaRepository.getReferenceById(id);
        conferenciaRepository.delete(conferencia);
        return conferencia;
    }

    public ConferenciaSemanalRelatorioDTO semanas(Integer semanas) {

        List<ConferenciaSemanalDTO> contagemSemanal = new ArrayList<>();

        for (int i = 0; i < semanas; i++) {

            IntervaloDatasDTO intervaloDatasDTO =
                    PeriodoUtils.obterIntervaloSextaAQuinta(i);

            long total = conferenciaRepository.countByDataBetween(
                    intervaloDatasDTO.dataInicio(),
                    intervaloDatasDTO.dataFim()
            );

            ConferenciaSemanalDTO novaContagem =
                    new ConferenciaSemanalDTO(
                            intervaloDatasDTO.dataInicio(),
                            intervaloDatasDTO.dataFim(),
                            total
                    );

            contagemSemanal.add(novaContagem);
        }

        return new ConferenciaSemanalRelatorioDTO(
                usuarioAutenticado.getUsuario(),
                contagemSemanal
        );
    }

}
