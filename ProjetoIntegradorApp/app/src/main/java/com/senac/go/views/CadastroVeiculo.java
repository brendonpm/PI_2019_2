package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.senac.go.R;
import com.senac.go.models.Veiculo;
import com.senac.go.repository.IVeiculoRepository;
import com.senac.go.repository.VeiculoRepository;
import com.senac.go.repository.source.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CadastroVeiculo extends AppCompatActivity {

    public long codusu;
    public VeiculoRepository veirepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro_veiculo);

        Intent intent = getIntent();
        if (intent.hasExtra("usuario")) {
            this.codusu = intent.getExtras().getLong("usuario");
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.165:9898").addConverterFactory(GsonConverterFactory.create()).build();
        Api veiculoapi = retrofit.create(Api.class);
        veirepository = new VeiculoRepository(veiculoapi);

        final RadioButton rMoto = findViewById(R.id.radiomoto);
        RadioButton rCarro = findViewById(R.id.radiocarro);
        Button bCadastrar = findViewById(R.id.bCadastrar);
        final EditText textPlaca = findViewById(R.id.TextPlaca);

        rCarro.setSelected(true);

        bCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tipo;
                if(rMoto.isSelected()){
                    tipo = "M";
                }else{
                    tipo = "C";
                }
                Veiculo vei = new Veiculo((long) 1,tipo,textPlaca.getText().toString(),codusu);

                veirepository.crie(vei, new IVeiculoRepository.Callback<Veiculo>() {
                    @Override
                    public void onResult(Veiculo result) {

                    }

                    @Override
                    public void onError(Exception e) {

                    }

                    @Override
                    public void onEmpty() {

                    }
                });
            }
        });
    }
}
