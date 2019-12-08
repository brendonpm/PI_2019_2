package com.senac.go.repository;

import android.os.AsyncTask;

import com.senac.go.models.Usuario;
import com.senac.go.repository.source.UserApi;
import com.senac.go.repository.source.UserMemorySource;
import com.senac.go.repository.task.LoadAllUser;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserRepository implements IUserRepository {

    private UserMemorySource userMemorySource;
    private UserApi userApi;

    public UserRepository(UserMemorySource userMemorySource, UserApi userApi) {
        this.userMemorySource = userMemorySource;
        this.userApi = userApi;
    }

    @Override
    public void crie(Usuario model, Callback<Usuario> callback) {

    }

    @Override
    public void delete(Usuario model, Callback<Usuario> callback) {

    }

    @Override
    public void recupere(Long identificador, Callback<Usuario> callback) {

    }

    @Override
    public void atualize(Usuario model, Callback<Usuario> callback) {

    }

    @Override
    public List<Usuario> getAll(Callback<List<Usuario>> callback, String nome) {
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
