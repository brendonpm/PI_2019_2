package com.senac.go.repository;

import android.os.AsyncTask;

import com.senac.go.models.Usuario;
import com.senac.go.source.UsuarioApi;
import com.senac.go.task.LoadUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Credentials;

public class UsuarioRepository implements IUsuarioRepository {

    public UsuarioApi usuarioApi;

    public UsuarioRepository(UsuarioApi usuarioApi) {
        this.usuarioApi = usuarioApi;
    }

    @Override
    public void getUsuarioLoguin(Callback<List<Usuario>> callback,String user) {

        AsyncTask<String, Integer, List<Usuario>> asyncTask = new LoadUser(usuarioApi, callback,user);
        asyncTask.execute();
    }
}
