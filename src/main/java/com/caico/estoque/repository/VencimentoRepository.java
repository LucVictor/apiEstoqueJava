package com.caico.estoque.repository;

import com.caico.estoque.model.Vencimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VencimentoRepository extends JpaRepository<Vencimento, Long>{
}
