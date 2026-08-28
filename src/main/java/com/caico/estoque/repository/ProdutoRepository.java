package com.caico.estoque.repository;

import com.caico.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByCodigo(Long codigo);
    Optional<Produto> findByCodigoBarras(Long barras);
    boolean existsByCodigo(Long codigo);
}