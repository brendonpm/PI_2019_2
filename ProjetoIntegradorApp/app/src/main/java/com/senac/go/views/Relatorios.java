package com.senac.go.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.senac.go.R;
import com.senac.go.models.Abastecimento;
import com.senac.go.models.Veiculo;
import com.senac.go.repository.AbasRepository;
import com.senac.go.repository.IAbasRepository;
import com.senac.go.repository.IVeiculoRepository;
import com.senac.go.repository.VeiculoRepository;
import com.senac.go.repository.source.Api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Relatorios extends AppCompatActivity {

    public long codusu;
    public VeiculoRepository veirepository;
    public AbasRepository abasRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_relatorios);

        Intent intent = getIntent();
        if (intent.hasExtra("usuario")) {
            this.codusu = intent.getExtras().getLong("usuario");
        }

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.31.14:9898").addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        veirepository = new VeiculoRepository(api);
        abasRepository = new AbasRepository(api);
    }
    @Override
    protected void onStart() {
        super.onStart();

        //------------------------------------------------------------------------------------------
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        veiculos.addAll( veirepository.getAll(new IVeiculoRepository.Callback<List<Veiculo>>() {
            @Override
            public void onResult(List<Veiculo> result) {
                Toast.makeText(Relatorios.this, "Veiculos carregados", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(Exception e) {
                Toast.makeText(Relatorios.this, "Erro", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onEmpty() {
                Toast.makeText(Relatorios.this, "Vazio", Toast.LENGTH_SHORT).show();
            }
        },codusu));

        ArrayList<Abastecimento> abast = new ArrayList<>();
        abast.addAll( abasRepository.getAll(new IAbasRepository.Callback<List<Abastecimento>>() {
            @Override
            public void onResult(List<Abastecimento> result) {
                Toast.makeText(Relatorios.this, "Abastecimentos Carregados", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(Exception e) {
                Toast.makeText(Relatorios.this, "Erro", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onEmpty() {
                Toast.makeText(Relatorios.this, "Vazio", Toast.LENGTH_SHORT).show();
            }
        },codusu));

        //------------------------------------------------------------------------------------------

        List<String> placa = new LinkedList<>();
        List<String> veic = new LinkedList<>();
        List<String> postcaro = new LinkedList<>();
        List<String> postbarato = new LinkedList<>();
        List<String> media = new LinkedList<>();

        for(int i=0; i<veiculos.size();i++){
            ArrayList<Abastecimento> abastTemp = new ArrayList<>();
            for(int j=0; j<abast.size();j++){
                if(veiculos.get(i).getCod().equals(abast.get(j).getCod_vei())){
                    abastTemp.add(abast.get(j));
                }
            }
            placa.add(veiculos.get(i).getPlaca()); //=============================================== placa
            veic.add(veiculos.get(i).getTipo()); //================================================= tipo

            long menor_vlr = 10000;
            String menor = "";
            for(int j=0; j<abastTemp.size();j++){
                if((abastTemp.get(j).getValor_pg()/abastTemp.get(j).getLitros()) < menor_vlr){
                    menor_vlr = abastTemp.get(j).getValor_pg()/abastTemp.get(j).getLitros();
                    menor = abastTemp.get(j).getNome_posto()+" R$"+menor_vlr+" p/L";
                }
            }
            postbarato.add(menor); //=============================================================== posto barato

            long maior_vlr = 0;
            String maior = "";
            for(int j=0; j<abastTemp.size();j++){
                if((abastTemp.get(j).getValor_pg()/abastTemp.get(j).getLitros()) >= maior_vlr){
                    maior_vlr = abastTemp.get(j).getValor_pg()/abastTemp.get(j).getLitros();
                    maior = abastTemp.get(j).getNome_posto() +" R$"+maior_vlr+" p/L";
                }
            }
            postcaro.add(maior); //================================================================= posto caro

            if(abastTemp.size()>1){
                long km;
                long litros;
                km = (abastTemp.get(abastTemp.size()-1).getOdometro()) - (abastTemp.get(abastTemp.size()-2).getOdometro());
                litros = abastTemp.get(abastTemp.size()-1).getLitros();
                media.add(String.valueOf(km/litros)); //============================================ media
            }else{
                media.add("Faça mais um abastecimento!"); //======================================== media
            }
        }
        RecyclerView recycler = findViewById(R.id.recycleRelat);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new RelatoriosAdapter(this, veic,placa,postcaro,postbarato,media));
    }
}
