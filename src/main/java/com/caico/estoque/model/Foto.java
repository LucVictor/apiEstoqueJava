package com.caico.estoque.model;

import jakarta.persistence.*;

@Entity
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeOriginal;
    private String nomeSalvo;
    private String caminho;

    public Foto() {}

    public Foto(String nomeOriginal, String nomeSalvo, String caminho) {
        this.nomeOriginal = nomeOriginal;
        this.nomeSalvo = nomeSalvo;
        this.caminho = caminho;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getNomeOriginal() { return nomeOriginal; }
    public String getNomeSalvo() { return nomeSalvo; }
    public String getCaminho() { return caminho; }
}