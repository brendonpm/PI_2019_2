package com.example.soft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.soft.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	@Query("SELECT v FROM Veiculo v WHERE v.cod_usuario = ?1")
	List<Veiculo> findByDono(Long cod);
	
	@Query("SELECT v FROM Veiculo v WHERE v.placa = ?1")
	List<Veiculo> findByPlaca(String cod);
}
