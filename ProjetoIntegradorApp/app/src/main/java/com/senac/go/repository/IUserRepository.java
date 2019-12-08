package com.senac.go.repository;

import com.senac.go.models.Usuario;

import java.util.List;

public interface IUserRepository {

    void crie(Usuario model, Callback<Usuario> callback);

    void delete(Usuario model, Callback<Usuario> callback);

    void recupere(Long identificador, Callback<Usuario> callback);

    void atualize(Usuario model, Callback<Usuario> callback);

    List<Usuario> getAll(Callback<List<Usuario>> callback, String nome);

    interface Callback<ResultType> {

        String onResult(ResultType result);

        String onError(Exception e);

        String onEmpty();
    }

}
