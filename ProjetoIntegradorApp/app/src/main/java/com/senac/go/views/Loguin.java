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
import com.senac.go.repository.IUserRepository;
import com.senac.go.repository.UserRepository;
import com.senac.go.repository.source.Api;
import com.senac.go.repository.status.InternetStatus;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loguin extends AppCompatActivity {

    public UserRepository usuariorepository;
    public InternetStatus istatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_loguin);

        istatus = new InternetStatus();
        if(istatus.isNetworkAvailable(this.getApplicationContext())){
            Toast.makeText(this, "Você está conectado!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Você não está conectado!", Toast.LENGTH_SHORT).show();
        }


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.31.14:9898").addConverterFactory(GsonConverterFactory.create()).build();

        Api usuarioapi = retrofit.create(Api.class);
        usuariorepository = new UserRepository(usuarioapi);

        final EditText nomeLoguin = findViewById(R.id.nomeLoguin);
        final EditText senhaLoguin = findViewById(R.id.senhaLoguin);


        Button bEntrar = findViewById(R.id.bEntrar);

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nomeLoguin.getText().toString().equals("")) {
                    Toast.makeText(Loguin.this, "Informe o nome!", Toast.LENGTH_SHORT).show();
                } else{
                    ArrayList<Usuario> str = new ArrayList<>();
                    str.addAll(usuariorepository.getUser(new IUserRepository.Callback<List<Usuario>>() {

                        @Override
                        public String onResult(List<Usuario> result) {
                            Toast.makeText(Loguin.this, "Salvo", Toast.LENGTH_SHORT).show();
                            return "result";
                        }

                        @Override
                        public String onError(Exception e) {
                            Toast.makeText(Loguin.this, "Erro", Toast.LENGTH_SHORT).show();
                            return "error";
                        }

                        @Override
                        public String onEmpty() {
                            Toast.makeText(Loguin.this, "Vazio", Toast.LENGTH_SHORT).show();
                            return "empty";
                        }
                    }, nomeLoguin.getText().toString()));

                    if (str.get(0).getSenha().equals(senhaLoguin.getText().toString())) {
                        long codusu = str.get(0).getCod();
                        Intent inteMenu = new Intent(Loguin.this, Menu.class);
                        inteMenu.putExtra("usuario", codusu);
                        startActivity(inteMenu);
                    } else {
                        Toast.makeText(Loguin.this, "Senha errada vacilão!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
