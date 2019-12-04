package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.senac.go.R;

public class Loguin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_loguin);

        Button bEntrar = findViewById(R.id.bEntrar);

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inteMenu = new Intent(Loguin.this, Menu.class);
                startActivity(inteMenu);
            }
        });


    }
}
