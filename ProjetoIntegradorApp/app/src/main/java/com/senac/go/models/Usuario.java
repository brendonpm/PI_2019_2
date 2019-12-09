package com.senac.go.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Usuario {

    @PrimaryKey
    long cod;
    String nome;
    String senha;

    public Usuario() {
    }

    @Ignore
    public Usuario(long cod, String nome, String senha) {
        this.cod = cod;
        this.nome = nome;
        this.senha = senha;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cod=" + cod +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return getCod() == usuario.getCod() &&
                Objects.equals(getNome(), usuario.getNome()) &&
                Objects.equals(getSenha(), usuario.getSenha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod(), getNome(), getSenha());
    }
}
