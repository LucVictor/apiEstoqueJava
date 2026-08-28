package com.caico.estoque.repository;

import com.caico.estoque.model.Conferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface ConferenciaRepository extends JpaRepository<Conferencia, Long> {
    List<Conferencia> findByDataBetween(LocalDate inicio, LocalDate fim);
    long countByDataBetween(LocalDate dataInicio, LocalDate dataFim);
}
