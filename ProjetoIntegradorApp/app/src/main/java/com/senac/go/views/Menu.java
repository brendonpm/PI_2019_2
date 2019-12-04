package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.senac.go.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu);

        Button bListVeic = findViewById(R.id.bListVeic);
        Button bCadasVeic = findViewById(R.id.bCadasVeic);
        Button bListAbast = findViewById(R.id.bListAbast);
        Button bCadasAbast = findViewById(R.id.bCadasAbast);
        Button bRelatorios = findViewById(R.id.bRelatorios);

        bListVeic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLintVei = new Intent(Menu.this, ListaVeiculos.class);
                startActivity(intentLintVei);
            }
        });
        bCadasVeic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCadasVei = new Intent(Menu.this, CadastroVeiculo.class);
                startActivity(intentCadasVei);
            }
        });
        bListAbast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentListAbas = new Intent(Menu.this, ListaAbastecimento.class);
                startActivity(intentListAbas);
            }
        });
        bCadasAbast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCadasAbas = new Intent(Menu.this, CadastroAbastecimento.class);
                startActivity(intentCadasAbas);
            }
        });
        bRelatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRela = new Intent(Menu.this, Relatorios.class);
                startActivity(intentRela);
            }
        });


    }





}
