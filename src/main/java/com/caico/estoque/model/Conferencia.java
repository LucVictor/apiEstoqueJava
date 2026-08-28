package com.caico.estoque.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Conferencia {
    @Id
    @GeneratedValue()
    Long id;
    Long codigoProduto;
    String nomeProduto;
    Double quantidadeFisico;
    Double quantidadeSistema;
    Double diferenca;
    Integer filial;
    String usuario;
    LocalDate data;

    public Conferencia() {
    }

    public Conferencia(Long codigoProduto, String nomeProduto, Double quantidadeFisico, Double quantidadeSistema, Integer filial, String usuario) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeFisico = quantidadeFisico;
        this.quantidadeSistema = quantidadeSistema;
        this.diferenca = quantidadeSistema - quantidadeSistema;
        this.filial = filial;
        this.usuario = usuario;
        this.data =  LocalDate.now();
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

    public Double getQuantidadeFisico() {
        return quantidadeFisico;
    }

    public void setQuantidadeFisico(Double quantidadeFisico) {
        this.quantidadeFisico = quantidadeFisico;
    }

    public Double getQuantidadeSistema() {
        return quantidadeSistema;
    }

    public void setQuantidadeSistema(Double quantidadeSistema) {
        this.quantidadeSistema = quantidadeSistema;
    }

    public Double getDiferenca() {
        return diferenca;
    }

    public void setDiferenca(Double diferenca) {
        this.diferenca = diferenca;
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
