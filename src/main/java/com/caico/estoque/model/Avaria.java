package com.caico.estoque.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Avaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long codigoProduto;
    String nomeProduto;
    Double quantidade;
    Double valor;
    String observacoes;
    Integer filial;
    @Nullable
    Long fotoId;
    String usuario;
    LocalDate data;
    public Avaria() {
    }

    public Avaria(Long codigoProduto, String nomeProduto, Double quantidade, Double valor, String observacoes, Integer filial, Long fotoId, String usuario, LocalDate data) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.observacoes = observacoes;
        this.filial = filial;
        this.usuario = usuario;
        this.data = data;
        this.fotoId = fotoId;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
