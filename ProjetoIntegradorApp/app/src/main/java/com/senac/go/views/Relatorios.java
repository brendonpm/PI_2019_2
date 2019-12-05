package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.senac.go.R;

import java.util.LinkedList;
import java.util.List;

public class Relatorios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_relatorios);

        List<String> placa = new LinkedList<>();
        List<String> veic = new LinkedList<>();
        List<String> postcaro = new LinkedList<>();
        List<String> postbarato = new LinkedList<>();
        List<String> media = new LinkedList<>();

        placa.add("aaa-1234");
        placa.add("bbb-2345");

        veic.add("M");
        veic.add("C");

        postcaro.add("Todos");
        postcaro.add("Todos");

        postbarato.add("nao tem");
        postbarato.add("nao tem");

        media.add("10");
        media.add("8");


        RecyclerView recycler = findViewById(R.id.recycleRelat);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new RelatoriosAdapter(this, veic,placa,postcaro,postbarato,media));

    }
}
