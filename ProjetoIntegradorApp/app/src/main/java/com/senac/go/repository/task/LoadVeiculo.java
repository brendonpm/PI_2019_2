package com.senac.go.repository.task;

import android.os.AsyncTask;

import com.senac.go.models.Veiculo;
import com.senac.go.repository.IVeiculoRepository;
import com.senac.go.repository.source.Api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadVeiculo extends AsyncTask<String, Integer, List<Veiculo>> {

    private Api veiculoApi;
    private IVeiculoRepository.Callback<List<Veiculo>> callback;
    long codUsu;

    public LoadVeiculo(Api veiculoApi, IVeiculoRepository.Callback<List<Veiculo>> callback, long codUsu) {
        this.veiculoApi = veiculoApi;
        this.callback = callback;
        this.codUsu = codUsu;
    }

    @Override
    protected List<Veiculo> doInBackground(String... strings) {
        try {
            ArrayList<Veiculo> VeiList = new ArrayList<>();
            VeiList.addAll(veiculoApi.getVeiculos(codUsu).execute().body());
            return VeiList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
