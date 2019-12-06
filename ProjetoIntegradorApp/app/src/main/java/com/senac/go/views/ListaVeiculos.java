package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.senac.go.R;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaVeiculos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_veiculos);

        FloatingActionButton bPlusVeic = findViewById(R.id.bPlusVeic);

        bPlusVeic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListaVeiculos.this, CadastroVeiculo.class);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.16.1.4:9898").addConverterFactory(GsonConverterFactory.create()).build();








        List<String> placa = new LinkedList<>();
        List<String> veic = new LinkedList<>();

        placa.add("aaa-1234");
        placa.add("bbb-2345");
        placa.add("ccc-3456");

        veic.add("M");
        veic.add("C");
        veic.add("M");

        RecyclerView recycler = findViewById(R.id.RecyListVei);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new VeiculosAdapter(this, veic,placa));

    }
}
