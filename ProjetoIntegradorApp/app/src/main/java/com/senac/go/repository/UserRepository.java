package com.senac.go.repository;

import android.os.AsyncTask;

import com.senac.go.models.Usuario;
import com.senac.go.repository.source.Api;
import com.senac.go.repository.task.LoadAllUser;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserRepository implements IUserRepository {

    private Api userApi;

    public UserRepository(Api userApi) {
        this.userApi = userApi;
    }

    @Override
    public List<Usuario> getUser(Callback<List<Usuario>> callback, String nome) {
        AsyncTask<String, Integer, List<Usuario>> asyncTask = new LoadAllUser(userApi, callback,nome);
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
}
