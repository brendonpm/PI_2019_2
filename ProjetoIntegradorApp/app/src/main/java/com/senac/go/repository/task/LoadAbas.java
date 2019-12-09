package com.senac.go.repository.task;

import android.os.AsyncTask;

import com.senac.go.models.Abastecimento;
import com.senac.go.repository.IAbasRepository;
import com.senac.go.repository.source.Api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadAbas extends AsyncTask<String, Integer, List<Abastecimento>> {

    private Api abasApi;
    private IAbasRepository.Callback<List<Abastecimento>> callback;
    long codUsu;

    public LoadAbas(Api veiculoApi, IAbasRepository.Callback<List<Abastecimento>> callback, long codUsu) {
        this.abasApi = veiculoApi;
        this.callback = callback;
        this.codUsu = codUsu;
    }


    @Override
    protected List<Abastecimento> doInBackground(String... strings) {

        try {
            ArrayList<Abastecimento> abasList = new ArrayList<>();
            abasList.addAll(abasApi.getAbast(codUsu).execute().body());
            return abasList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
