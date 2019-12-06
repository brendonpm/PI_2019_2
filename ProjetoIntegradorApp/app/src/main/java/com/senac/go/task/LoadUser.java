package com.senac.go.task;

import android.os.AsyncTask;

import com.senac.go.models.Usuario;
import com.senac.go.repository.IUsuarioRepository;
import com.senac.go.source.UsuarioApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Credentials;

public class LoadUser extends AsyncTask<String, Integer, List<Usuario>> {

    private UsuarioApi userApi;
    private IUsuarioRepository.Callback<List<Usuario>> callback;
    String usuario;

    public LoadUser(UsuarioApi userApi, IUsuarioRepository.Callback<List<Usuario>> callback,String nome) {
        this.userApi = userApi;
        this.callback = callback;
        this.usuario = nome;
    }

    @Override
    protected List<Usuario> doInBackground(String... strings) {

        try {
            ArrayList<Usuario> userList = new ArrayList<>();
            //String credentials = Credentials.basic("root","toor");
            userList.addAll(userApi.getUsuarioLoguin(usuario).execute().body());
            return userList;
        } catch (IOException e) {
            callback.onError(e);
        } catch (Exception e) {
            callback.onError(e);
        }
        return null;
    }
}
