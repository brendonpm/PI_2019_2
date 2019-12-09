package com.senac.go.repository;

import com.senac.go.models.Abastecimento;

import java.util.List;

public interface IAbasRepository {

    List<Abastecimento> getAll(Callback<List<Abastecimento>> callback, long cod);

    void crie(Abastecimento model, Callback<Abastecimento> callback);

    interface Callback<ResultType> {

        void onResult(ResultType result);

        void onError(Exception e);

        void onEmpty();
    }
}
