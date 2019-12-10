package com.senac.go.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.senac.go.R;

import java.util.List;

public class AbastecimentosAdapter extends RecyclerView.Adapter<AbastecimentosAdapter.ViewHolder>{

    private final List<String> data;
    private final List<String> odometro;
    private final List<String> posto;
    private final List<String> litros;
    private final List<String> valor;
    private final List<String> veic;
    private final List<String> placa;
    private Context context;


    public AbastecimentosAdapter(Context context,List<String> veic,List<String> placa,List<String> data,List<String> odometro,List<String> posto,List<String> litros,List<String> valor){
        this.context = context;
        this.data = data;
        this.odometro = odometro;
        this.posto = posto;
        this.litros = litros;
        this.valor = valor;
        this.placa = placa;
        this.veic = veic;
    }

    @NonNull
    @Override
    public AbastecimentosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new AbastecimentosAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycle_abaste, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AbastecimentosAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(placa.get(i),veic.get(i),data.get(i),odometro.get(i),posto.get(i),litros.get(i),valor.get(i));

    }

    @Override
    public int getItemCount() {
        return placa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(String placa,String veic,String data,String odometro,String posto,String litros,String valor) {
            TextView title = itemView.findViewById(R.id.textplacaabast);
            title.setText(placa);
            TextView title2 = itemView.findViewById(R.id.textdataabast);
            title2.setText(data);
            TextView title3 = itemView.findViewById(R.id.textodometroabast);
            title3.setText("ODO: "+odometro);
            TextView title4 = itemView.findViewById(R.id.textpostoabast);
            title4.setText("Posto: "+posto);
            TextView title5 = itemView.findViewById(R.id.textlitrosabas);
            title5.setText(litros+"L");
            TextView title6 = itemView.findViewById(R.id.textvalorabast);
            title6.setText("R$ "+valor);

            if(veic.equals("M")){
                ImageView iv = itemView.findViewById(R.id.imageveicabast);
                iv.setImageResource(R.mipmap.moto);
            }else{
                ImageView iv = itemView.findViewById(R.id.imageveicabast);
                iv.setImageResource(R.mipmap.carro);
            }




        }
    }



}
