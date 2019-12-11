package com.senac.go.repository.task;

import android.os.AsyncTask;

import com.senac.go.models.Usuario;
import com.senac.go.repository.IUserRepository;
import com.senac.go.repository.source.Api;
import com.senac.go.repository.source.dao.UserDaoSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadUser extends AsyncTask<String, Integer, List<Usuario>> {

    private Api userApi;
    private IUserRepository.Callback<List<Usuario>> callback;
    String nome;
    private UserDaoSource daoSource;

    public LoadUser(Api userApi, IUserRepository.Callback<List<Usuario>> callback, String nome, UserDaoSource daoSource) {
        this.userApi = userApi;
        this.callback = callback;
        this.nome = nome;
        this.daoSource = daoSource;
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

    @Override
    protected void onPostExecute(List<Usuario> usuarios) {
        super.onPostExecute(usuarios);


//        AsyncTask<String, Integer, List<Usuario>> asyncTaskSave = new SaveUser(daoSource,callback,usuarios.get(0));
//        asyncTaskSave.execute();
    }
}
