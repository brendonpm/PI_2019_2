package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.senac.go.R;

public class Menu extends AppCompatActivity {

    public long codusu;

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

        Intent intent = getIntent();
        if (intent.hasExtra("usuario")) {
            this.codusu = intent.getExtras().getLong("usuario");
        }

        bListVeic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLintVei = new Intent(Menu.this, ListaVeiculos.class);
                intentLintVei.putExtra("usuario", codusu);
                startActivity(intentLintVei);
            }
        });
        bCadasVeic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCadasVei = new Intent(Menu.this, CadastroVeiculo.class);
                intentCadasVei.putExtra("usuario", codusu);
                startActivity(intentCadasVei);
            }
        });
        bListAbast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentListAbas = new Intent(Menu.this, ListaAbastecimento.class);
                intentListAbas.putExtra("usuario", codusu);
                startActivity(intentListAbas);
            }
        });
        bCadasAbast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCadasAbas = new Intent(Menu.this, CadastroAbastecimento.class);
                intentCadasAbas.putExtra("usuario", codusu);
                startActivity(intentCadasAbas);
            }
        });
        bRelatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRela = new Intent(Menu.this, Relatorios.class);
                intentRela.putExtra("usuario", codusu);
                startActivity(intentRela);
            }
        });


    }





}
