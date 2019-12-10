package com.senac.go.repository.task;

import android.os.AsyncTask;

import com.senac.go.models.Usuario;
import com.senac.go.repository.IUserRepository;
import com.senac.go.repository.source.Api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadUser extends AsyncTask<String, Integer, List<Usuario>> {

    private Api userApi;
    private IUserRepository.Callback<List<Usuario>> callback;
    String nome;

    public LoadUser(Api userApi, IUserRepository.Callback<List<Usuario>> callback, String nome) {
        this.userApi = userApi;
        this.callback = callback;
        this.nome = nome;
    }

    @Override
    protected List<Usuario> doInBackground(String... strings) {
        try {
            ArrayList<Usuario> userList = new ArrayList<>();
            userList.addAll(userApi.getUser(nome).execute().body());
            return userList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}