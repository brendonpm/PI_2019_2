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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.senac.go.R;
import com.senac.go.models.Veiculo;
import com.senac.go.repository.IVeiculoRepository;
import com.senac.go.repository.VeiculoRepository;
import com.senac.go.repository.source.Api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaVeiculos extends AppCompatActivity {

    public long codusu;
    public VeiculoRepository veirepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_veiculos);

        FloatingActionButton bPlusVeic = findViewById(R.id.bPlusVeic);
        Intent intent = getIntent();
        if (intent.hasExtra("usuario")) {
            this.codusu = intent.getExtras().getLong("usuario");
        }

        bPlusVeic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListaVeiculos.this, CadastroVeiculo.class);
                intent.putExtra("usuario", codusu);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.165:9898").addConverterFactory(GsonConverterFactory.create()).build();
        Api veiculoapi = retrofit.create(Api.class);
        veirepository = new VeiculoRepository(veiculoapi);
    }
    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<Veiculo> str = new ArrayList<>();
        str.addAll( veirepository.getAll(new IVeiculoRepository.Callback<List<Veiculo>>() {
            @Override
            public void onResult(List<Veiculo> result) {
                Toast.makeText(ListaVeiculos.this, "Carregado", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(Exception e) {
                Toast.makeText(ListaVeiculos.this, "Erro", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onEmpty() {
                Toast.makeText(ListaVeiculos.this, "Vazio", Toast.LENGTH_SHORT).show();
            }
        },codusu));

        List<String> placa = new LinkedList<>();
        List<String> tipo = new LinkedList<>();

        for(int i=0;i<str.size();i++){
            placa.add(str.get(i).getPlaca());
        }
        for(int i=0;i<str.size();i++){
            tipo.add(str.get(i).getTipo());
        }
        RecyclerView recycler = findViewById(R.id.RecyListVei);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new VeiculosAdapter(this, tipo,placa));
    }


}
