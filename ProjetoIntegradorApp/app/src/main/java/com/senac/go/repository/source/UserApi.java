package com.senac.go.repository.source;

import com.senac.go.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface UserApi {

    @GET("user/nome/{nome}")
    Call<List<Usuario>> getUser(@Path("nome") String nome);

    @Headers({"Authorization: Basic cm9vdDp0b29y"})
    @GET("veiculo")
    Call<List<Usuario>> getVeiculos();


}
