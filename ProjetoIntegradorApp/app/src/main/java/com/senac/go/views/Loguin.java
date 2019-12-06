package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.senac.go.R;
import com.senac.go.models.Usuario;
import com.senac.go.repository.IUsuarioRepository;
import com.senac.go.repository.UsuarioRepository;
import com.senac.go.source.UsuarioApi;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loguin extends AppCompatActivity {

    public UsuarioRepository usuariorepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_loguin);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.165:9898").addConverterFactory(GsonConverterFactory.create()).build();

        UsuarioApi usuarioapi = retrofit.create(UsuarioApi.class);
        usuariorepository = new UsuarioRepository(usuarioapi);


        Button bEntrar = findViewById(R.id.bEntrar);

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText nomeLoguin = findViewById(R.id.nomeLoguin);
                final EditText senhaLoguin = findViewById(R.id.senhaLoguin);

//                Intent inteMenu = new Intent(Loguin.this, Menu.class);
//                startActivity(inteMenu);


                usuariorepository.getUsuarioLoguin(new IUsuarioRepository.Callback<List<Usuario>>() {

                    @Override
                    public void onResult(List<Usuario> result) {
                        Toast.makeText(Loguin.this, "entrou", Toast.LENGTH_SHORT).show();

                         if(result.get(0).getNome().equals(nomeLoguin.getText().toString()) && result.get(0).getSenha().equals(senhaLoguin.getText().toString())){
                             Intent inteMenu = new Intent(Loguin.this, Menu.class);
                             startActivity(inteMenu);
                         }else{
                            Toast.makeText(Loguin.this, "Usuario e/ou Senha errados", Toast.LENGTH_SHORT).show();
                         }
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(Loguin.this, "Erro: " +e.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEmpty() {
                        Toast.makeText(Loguin.this, "Vazio", Toast.LENGTH_SHORT).show();
                    }
                },nomeLoguin.getText().toString());
            }
        });



    }
}
