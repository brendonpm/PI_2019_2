package com.senac.go.models;

import java.util.Date;
import java.util.Objects;

public class Veiculo {

    long cod;
    String tipo;
    String placa;
    long cod_usu;

    public Veiculo() {
    }

    public Veiculo(Long cod, String tipo, String placa, Long cod_usu) {
        this.cod = cod;
        this.tipo = tipo;
        this.placa = placa;
        this.cod_usu = cod_usu;
    }

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

    public Long getCod_usu() {
        return cod_usu;
    }

    public void setCod_usu(Long cod_usu) {
        this.cod_usu = cod_usu;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "cod=" + cod +
                ", tipo='" + tipo + '\'' +
                ", placa='" + placa + '\'' +
                ", cod_usu=" + cod_usu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(cod, veiculo.cod) &&
                Objects.equals(tipo, veiculo.tipo) &&
                Objects.equals(placa, veiculo.placa) &&
                Objects.equals(cod_usu, veiculo.cod_usu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, tipo, placa, cod_usu);
    }
}
