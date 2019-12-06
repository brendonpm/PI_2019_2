package com.senac.go.models;

import java.util.Date;
import java.util.Objects;

public class Abastecimento {

    long cod;
    Date data;
    long odometro;
    String nome_posto;
    long litros;
    long valor_pg;
    long cod_usu;
    long cod_vei;

    public Abastecimento() {
    }

    public Abastecimento(long cod, Date data, long odometro, String nome_posto, long litros, long valor_pg, long cod_usu, long cod_vei) {
        this.cod = cod;
        this.data = data;
        this.odometro = odometro;
        this.nome_posto = nome_posto;
        this.litros = litros;
        this.valor_pg = valor_pg;
        this.cod_usu = cod_usu;
        this.cod_vei = cod_vei;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getOdometro() {
        return odometro;
    }

    public void setOdometro(long odometro) {
        this.odometro = odometro;
    }

    public String getNome_posto() {
        return nome_posto;
    }

    public void setNome_posto(String nome_posto) {
        this.nome_posto = nome_posto;
    }

    public long getLitros() {
        return litros;
    }

    public void setLitros(long litros) {
        this.litros = litros;
    }

    public long getValor_pg() {
        return valor_pg;
    }

    public void setValor_pg(long valor_pg) {
        this.valor_pg = valor_pg;
    }

    public long getCod_usu() {
        return cod_usu;
    }

    public void setCod_usu(long cod_usu) {
        this.cod_usu = cod_usu;
    }

    public long getCod_vei() {
        return cod_vei;
    }

    public void setCod_vei(long cod_vei) {
        this.cod_vei = cod_vei;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "cod=" + cod +
                ", data=" + data +
                ", odometro=" + odometro +
                ", nome_posto='" + nome_posto + '\'' +
                ", litros=" + litros +
                ", valor_pg=" + valor_pg +
                ", cod_usu=" + cod_usu +
                ", cod_vei=" + cod_vei +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abastecimento that = (Abastecimento) o;
        return cod == that.cod &&
                odometro == that.odometro &&
                litros == that.litros &&
                valor_pg == that.valor_pg &&
                cod_usu == that.cod_usu &&
                cod_vei == that.cod_vei &&
                Objects.equals(data, that.data) &&
                Objects.equals(nome_posto, that.nome_posto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, data, odometro, nome_posto, litros, valor_pg, cod_usu, cod_vei);
    }
}
