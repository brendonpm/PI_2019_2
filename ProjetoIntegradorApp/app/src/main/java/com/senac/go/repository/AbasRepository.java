package com.senac.go.repository;

import android.os.AsyncTask;

import com.senac.go.models.Abastecimento;
import com.senac.go.repository.source.Api;
import com.senac.go.repository.task.LoadAbas;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class AbasRepository implements IAbasRepository {

    private Api veiApi;

    public AbasRepository(Api veiApi) {
        this.veiApi = veiApi;
    }

    @Override
    public List<Abastecimento> getAll(Callback<List<Abastecimento>> callback, long cod) {
        AsyncTask<String, Integer, List<Abastecimento>> asyncTask = new LoadAbas(veiApi,callback,cod);
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
    public void crie(Abastecimento model, Callback<Abastecimento> callback) {

    }
}
