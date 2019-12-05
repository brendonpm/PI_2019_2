package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.senac.go.R;

import java.util.LinkedList;
import java.util.List;

public class ListaAbastecimento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_abastecimento);

        FloatingActionButton bPlusabas = findViewById(R.id.bPlusAbas);

        bPlusabas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListaAbastecimento.this, CadastroAbastecimento.class);
                startActivity(intent);
            }
        });

        List<String> placa = new LinkedList<>();
        List<String> veic = new LinkedList<>();
        List<String> data = new LinkedList<>();
        List<String> odometro = new LinkedList<>();
        List<String> posto = new LinkedList<>();
        List<String> litros = new LinkedList<>();
        List<String> valor = new LinkedList<>();

        placa.add("aaa-1234");
        placa.add("bbb-2345");

        veic.add("M");
        veic.add("S");

        data.add("12/12/2012 - 01:50");
        data.add("11/11/2011 - 12:40");

        odometro.add("456168");
        odometro.add("120000");

        posto.add("Roubando você");
        posto.add("Furtando você");

        litros.add("30");
        litros.add("20");

        valor.add("80");
        valor.add("80");


        RecyclerView recycler = findViewById(R.id.recycleAbast);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new AbastecimentosAdapter(this,veic,placa,data,odometro,posto,litros,valor));
    }
}
