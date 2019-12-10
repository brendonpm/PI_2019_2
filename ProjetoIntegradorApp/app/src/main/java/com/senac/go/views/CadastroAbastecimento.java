package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.senac.go.R;
import com.senac.go.models.Abastecimento;
import com.senac.go.models.Veiculo;
import com.senac.go.repository.AbasRepository;
import com.senac.go.repository.IAbasRepository;
import com.senac.go.repository.IVeiculoRepository;
import com.senac.go.repository.VeiculoRepository;
import com.senac.go.repository.source.Api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CadastroAbastecimento extends AppCompatActivity {

    public long codusu;
    public AbasRepository abasrepository;
    public VeiculoRepository veirepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro_abastecimento);

        Intent intent = getIntent();
        if (intent.hasExtra("usuario")) {
            this.codusu = intent.getExtras().getLong("usuario");
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.31.14:9898").addConverterFactory(GsonConverterFactory.create()).build();
        Api abasapi = retrofit.create(Api.class);
        abasrepository = new AbasRepository(abasapi);
        veirepository = new VeiculoRepository(abasapi);

        Button bregabas = findViewById(R.id.bRegAbas);

        bregabas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText odo = findViewById(R.id.odometro);
                EditText nome_posto = findViewById(R.id.posto);
                EditText litros = findViewById(R.id.litros);
                EditText valor_pg = findViewById(R.id.valor);
                EditText placa = findViewById(R.id.placa);

                ArrayList<Veiculo> str = new ArrayList<>();
                str.addAll( veirepository.getAll(new IVeiculoRepository.Callback<List<Veiculo>>() {
                    @Override
                    public void onResult(List<Veiculo> result) {
                        Toast.makeText(CadastroAbastecimento.this, "Carregado", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(CadastroAbastecimento.this, "Erro", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onEmpty() {
                        Toast.makeText(CadastroAbastecimento.this, "Vazio", Toast.LENGTH_SHORT).show();
                    }
                },codusu));
                long cod_veiculo = 0;

                for(int i=0;i<str.size();i++){
                    if(str.get(i).getPlaca().equals(placa.getText().toString())){
                        cod_veiculo = str.get(i).getCod();
                    }
                }

                Abastecimento abas = new Abastecimento();

                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                Date data = new Date();

                abas.setData(formato.format(data));
                abas.setOdometro(Long.valueOf(odo.getText().toString()));
                abas.setNome_posto(nome_posto.getText().toString());
                abas.setLitros(Long.valueOf(litros.getText().toString()));
                abas.setValor_pg(Long.valueOf(valor_pg.getText().toString()));
                abas.setCod_usu(codusu);
                Toast.makeText(CadastroAbastecimento.this, "usu: "+ codusu, Toast.LENGTH_SHORT).show();
                abas.setCod_vei(cod_veiculo);
                Toast.makeText(CadastroAbastecimento.this, "vei: "+ cod_veiculo, Toast.LENGTH_SHORT).show();

                abasrepository.crie(abas,new IAbasRepository.Callback<Abastecimento>() {
                    @Override
                    public void onResult(Abastecimento result) {
                        Toast.makeText(CadastroAbastecimento.this, "Salvo", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(CadastroAbastecimento.this, "Erro", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onEmpty() {
                        Toast.makeText(CadastroAbastecimento.this, "Vazio", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
