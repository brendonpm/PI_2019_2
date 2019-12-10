package com.senac.go.repository.source;

import com.senac.go.models.Abastecimento;
import com.senac.go.models.Usuario;
import com.senac.go.models.Veiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @Headers({"Authorization: Basic cm9vdDp0b29y"})
    @GET("user/nome/{nome}")
    Call<List<Usuario>> getUser(@Path("nome") String nome);

    @Headers({"Authorization: Basic cm9vdDp0b29y"})
    @GET("veiculo/dono/{cod}")
    Call<List<Veiculo>> getVeiculos(@Path("cod") long cod);

    @Headers({"Authorization: Basic cm9vdDp0b29y"})
    @POST("veiculo")
    Call<Veiculo> setVeiculo(@Body Veiculo veiculo);

    @Headers({"Authorization: Basic cm9vdDp0b29y"})
    @GET("abastecimento/usuario/{cod}")
    Call<List<Abastecimento>> getAbast(@Path("cod") long cod);

    @Headers({"Authorization: Basic cm9vdDp0b29y"})
    @POST("abastecimento")
    Call<Abastecimento> setAbast(@Body Abastecimento abast);




}
