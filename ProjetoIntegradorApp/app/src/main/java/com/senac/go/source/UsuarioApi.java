package com.senac.go.source;

import com.senac.go.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface UsuarioApi {

    //@Headers("Authorization: "+Credentials.basic("root","toor");)
    @GET("abastecimento")
    Call<List<Usuario>> getUsuarios(@Header("Authorization") String credentials);


}
