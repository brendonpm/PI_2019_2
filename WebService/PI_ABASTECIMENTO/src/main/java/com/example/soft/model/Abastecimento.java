package com.example.soft.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ABASTECIMENTO")
public class Abastecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD")
	Long cod;
	@Column(name = "DATA")
	Date data;
	@Column(name = "ODOMETRO")
	Long odometro;
	@Column(name = "NOME_POSTO")
	String nome_posto;
	@Column(name = "LITROS")
	Long litros;
	@Column(name = "VALOR_PG")
	Long valor_pg;
	@Column(name = "COD_USUARIO")
	Long cod_usuario;
	@Column(name = "COD_VEICULO")
	Long cod_veiculo;
	
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Long getOdometro() {
		return odometro;
	}
	public void setOdometro(Long odometro) {
		this.odometro = odometro;
	}
	public String getNome_posto() {
		return nome_posto;
	}
	public void setNome_posto(String nome_posto) {
		this.nome_posto = nome_posto;
	}
	public Long getLitros() {
		return litros;
	}
	public void setLitros(Long litros) {
		this.litros = litros;
	}
	public Long getValor_pg() {
		return valor_pg;
	}
	public void setValor_pg(Long valor_pg) {
		this.valor_pg = valor_pg;
	}
	public Long getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public Long getCod_veiculo() {
		return cod_veiculo;
	}
	public void setCod_veiculo(Long cod_veiculo) {
		this.cod_veiculo = cod_veiculo;
	}
	
	
	
	
	
	
}
