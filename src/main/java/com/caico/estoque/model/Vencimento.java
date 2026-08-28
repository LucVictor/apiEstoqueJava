package com.caico.estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Vencimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigoProduto;
    private String nomeProduto;
    private Double quantidade;
    private String lote;
    private Integer filial;
    private String usuario;
    private LocalDate dataVencimento;
    private LocalDate criadoEm;
    private LocalDate modificadoEm;


    public Vencimento() {
    }

    public Vencimento(Long codigoProduto, String nomeProduto, Double quantidade, String lote, Integer filial, String usuario, LocalDate dataVencimento) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.lote = lote;
        this.filial = filial;
        this.usuario = usuario;
        this.dataVencimento = dataVencimento;
        this.criadoEm = LocalDate.now();
        this.modificadoEm = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Integer getFilial() {
        return filial;
    }

    public void setFilial(Integer filial) {
        this.filial = filial;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDate getModificadoEm() {
        return modificadoEm;
    }

    public void setModificadoEm(LocalDate modificadoEm) {
        this.modificadoEm = modificadoEm;
    }
}
