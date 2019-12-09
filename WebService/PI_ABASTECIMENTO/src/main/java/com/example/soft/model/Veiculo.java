package com.example.soft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD")
	Long cod;
	@Column(name = "TIPO")
	String tipo;
	@Column(name = "PLACA")
	String placa;
	@Column(name = "COD_USUARIO")
	Long cod_usuario;
	
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Long getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	
	
}
