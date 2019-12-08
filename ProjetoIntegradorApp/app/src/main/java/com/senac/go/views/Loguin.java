package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.senac.go.R;
import com.senac.go.models.Usuario;
import com.senac.go.repository.IUserRepository;
import com.senac.go.repository.UserRepository;
import com.senac.go.repository.source.UserApi;
import com.senac.go.repository.source.UserMemorySourceImpl;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loguin extends AppCompatActivity {

    public UserRepository usuariorepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_loguin);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.4:9898").addConverterFactory(GsonConverterFactory.create()).build();

        UserApi usuarioapi = retrofit.create(UserApi.class);
        usuariorepository = new UserRepository(new UserMemorySourceImpl(), usuarioapi);

        final EditText nomeLoguin = findViewById(R.id.nomeLoguin);
        final EditText senhaLoguin = findViewById(R.id.senhaLoguin);


        Button bEntrar = findViewById(R.id.bEntrar);

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                Intent inteMenu = new Intent(Loguin.this, Menu.class);
//                startActivity(inteMenu);

                ArrayList<Usuario> str = new ArrayList<>();
                str.addAll(usuariorepository.getAll(new IUserRepository.Callback<List<Usuario>>() {

                    @Override
                    public String onResult(List<Usuario> result) {
                        return "result";
                    }

                    @Override
                    public String onError(Exception e) {

                        return "erro";
                    }

                    @Override
                    public String onEmpty() {

                        return "zero";
                    }
                },nomeLoguin.getText().toString()));

                //nomeLoguin.setText(str.get(0).getSenha());

                if(str.get(0).getSenha().equals(senhaLoguin.getText().toString())){
                    Intent inteMenu = new Intent(Loguin.this, Menu.class);
                    startActivity(inteMenu);
                }else{
                    Toast.makeText(Loguin.this, "Cê burro? Senha errada!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
