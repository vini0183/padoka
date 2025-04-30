package com.example.senai.core.repository;

import com.example.senai.core.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT DISTINCT c.nome FROM Produto c")
    Set<String> findAllUniqueNomes();
}
