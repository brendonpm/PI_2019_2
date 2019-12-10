package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.senac.go.R;
import com.senac.go.models.Abastecimento;
import com.senac.go.models.Veiculo;
import com.senac.go.repository.AbasRepository;
import com.senac.go.repository.IAbasRepository;
import com.senac.go.repository.IVeiculoRepository;
import com.senac.go.repository.VeiculoRepository;
import com.senac.go.repository.source.Api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaAbastecimento extends AppCompatActivity {

    public long codusu;
    public AbasRepository abasRepository;
    public VeiculoRepository veirepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_abastecimento);

        FloatingActionButton bPlusabas = findViewById(R.id.bPlusAbas);
        Intent intent = getIntent();
        if (intent.hasExtra("usuario")) {
            this.codusu = intent.getExtras().getLong("usuario");
        }

        bPlusabas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListaAbastecimento.this, CadastroAbastecimento.class);
                intent.putExtra("usuario", codusu);
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.165:9898").addConverterFactory(GsonConverterFactory.create()).build();
        Api abasapi = retrofit.create(Api.class);

        abasRepository = new AbasRepository(abasapi);
        veirepository = new VeiculoRepository(abasapi);
    }
    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<Abastecimento> str = new ArrayList<>();
        str.addAll( abasRepository.getAll(new IAbasRepository.Callback<List<Abastecimento>>() {
            @Override
            public void onResult(List<Abastecimento> result) {
            }
            @Override
            public void onError(Exception e) {
            }
            @Override
            public void onEmpty() {
            }
        },codusu));

        List<String> placa = new LinkedList<>();
        List<String> tipo = new LinkedList<>();
        List<String> data = new LinkedList<>();
        List<String> odometro = new LinkedList<>();
        List<String> posto = new LinkedList<>();
        List<String> litros = new LinkedList<>();
        List<String> valor = new LinkedList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<Veiculo> strvei = new ArrayList<>();
        strvei.addAll( veirepository.getAll(new IVeiculoRepository.Callback<List<Veiculo>>() {
            @Override
            public void onResult(List<Veiculo> result) {
            }
            @Override
            public void onError(Exception e) {
            }
            @Override
            public void onEmpty() {
            }
        },codusu));

        for(int i=0;i<str.size();i++){
            for(int j=0; j <strvei.size();j++){
                Long a = str.get(i).getCod_vei();
                Long b = strvei.get(j).getCod();
                if(a == b){
                    tipo.add(strvei.get(j).getTipo());
                    placa.add(strvei.get(j).getPlaca());
                }
            }
        }
        Date datag;
        for(int i=0;i<str.size();i++){
            try {
                datag = formato.parse(str.get(i).getData());
                data.add(formato.format(datag));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<str.size();i++){
            odometro.add(String.valueOf(str.get(i).getOdometro()));
        }
        for(int i=0;i<str.size();i++){
            posto.add(str.get(i).getNome_posto());
        }
        for(int i=0;i<str.size();i++){
            litros.add(String.valueOf(str.get(i).getLitros()));
        }
        for(int i=0;i<str.size();i++){
            valor.add(String.valueOf(str.get(i).getValor_pg()));
        }

        RecyclerView recycler = findViewById(R.id.recycleAbast);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new AbastecimentosAdapter(this,tipo,placa,data,odometro,posto,litros,valor));
    }
}
