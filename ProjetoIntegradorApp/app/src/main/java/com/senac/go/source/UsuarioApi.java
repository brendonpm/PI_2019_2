package com.senac.go.source;

import com.senac.go.models.Usuario;

import java.util.List;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface UsuarioApi {

    @Headers("Authorization: Basic cm9vdDp0b29y")
    @GET("user/nome/{nome}")
    Call<List<Usuario>> getUsuarioLoguin(@Path("nome") String nome);


}
