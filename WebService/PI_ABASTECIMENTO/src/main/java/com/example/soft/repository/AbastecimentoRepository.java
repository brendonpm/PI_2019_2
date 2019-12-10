package com.example.soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.soft.model.Abastecimento;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {

	@Query("SELECT a FROM Abastecimento a WHERE a.cod_usuario = ?1")
	List<Abastecimento> findByCodUsu(Long cod);
}
