package com.senac.go.repository;

import com.senac.go.models.Usuario;
import com.senac.go.source.UsuarioApi;

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
    public void getAll(Callback<List<Usuario>> callback) {

        try {
            ArrayList<Usuario> usuario = new ArrayList<>();
            String credentials = Credentials.basic("root","toor");
            usuario.addAll(usuarioApi.getUsuarios(credentials).execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
