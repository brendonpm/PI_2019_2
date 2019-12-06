package com.senac.go.repository;

import com.senac.go.models.Usuario;

import java.util.List;

public interface IUsuarioRepository {

    void getUsuarioLoguin(Callback<List<Usuario>> callback,String usuario);

    interface Callback<ResultType> {

        void onResult(ResultType result);

        void onError(Exception e);

        void onEmpty();
    }
}
