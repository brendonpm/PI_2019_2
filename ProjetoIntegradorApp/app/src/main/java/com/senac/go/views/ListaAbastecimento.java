package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.senac.go.R;

public class ListaAbastecimento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_abastecimento);

        FloatingActionButton bPlusAbas = findViewById(R.id.bPlusAbas);

        bPlusAbas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListaAbastecimento.this, CadastroAbastecimento.class);
                startActivity(intent);
            }
        });
    }
}
