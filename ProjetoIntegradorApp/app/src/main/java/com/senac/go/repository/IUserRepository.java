package com.senac.go.repository;

import com.senac.go.models.Usuario;

import java.util.List;

public interface IUserRepository {


    List<Usuario> getUser(Callback<List<Usuario>> callback, String nome);

    interface Callback<ResultType> {

        String onResult(ResultType result);

        String onError(Exception e);

        String onEmpty();
    }

}
