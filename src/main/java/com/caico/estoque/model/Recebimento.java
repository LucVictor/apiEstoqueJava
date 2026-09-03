package com.caico.estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Recebimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long fotoPranchetaId;
    LocalDate data;
    Integer filial;
    String usuario;

    public Recebimento() {
    }

    public Recebimento(Long id, Long fotoPranchetaId, LocalDate data, Integer filial, String usuario) {
        this.id = id;
        this.fotoPranchetaId = fotoPranchetaId;
        this.data = data;
        this.filial = filial;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFotoPranchetaId() {
        return fotoPranchetaId;
    }

    public void setFotoPranchetaId(Long fotoPranchetaId) {
        this.fotoPranchetaId = fotoPranchetaId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
}
