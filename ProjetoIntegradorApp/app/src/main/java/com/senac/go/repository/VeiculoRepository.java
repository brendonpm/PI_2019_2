package com.senac.go.repository;

import android.os.AsyncTask;

import com.senac.go.models.Veiculo;
import com.senac.go.repository.source.Api;
import com.senac.go.repository.task.LoadVeiculo;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;

public class VeiculoRepository implements IVeiculoRepository {

    private Api veiApi;

    public VeiculoRepository(Api veiApi) {
        this.veiApi = veiApi;
    }

    @Override
    public List<Veiculo> getAll(Callback<List<Veiculo>> callback, long cod) {
        AsyncTask<String, Integer, List<Veiculo>> asyncTask = new LoadVeiculo(veiApi,callback,cod);
        asyncTask.execute();
        try {
            return asyncTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void crie(Veiculo model, Callback<Veiculo> callback) {
        Call<Veiculo> asyncTask = veiApi.setVeiculo(model);
        try {
            asyncTask.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
