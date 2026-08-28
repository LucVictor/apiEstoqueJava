package com.caico.estoque.repository;

import com.caico.estoque.model.Avaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvariaRepository extends JpaRepository<Avaria, Long> {
    List<Avaria> findByDataBetween(LocalDate inicio, LocalDate fim);
}
