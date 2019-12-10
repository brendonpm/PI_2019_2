package com.senac.go.repository;

import com.senac.go.models.Veiculo;

import java.util.List;

public interface IVeiculoRepository {

    List<Veiculo> getAll(Callback<List<Veiculo>> callback,long cod);

    void crie(Callback<Veiculo> callback, Veiculo model);

    interface Callback<ResultType> {

        void onResult(ResultType result);

        void onError(Exception e);

        void onEmpty();
    }
}
