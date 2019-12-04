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

public class VeiculosAdapter extends RecyclerView.Adapter<VeiculosAdapter.ViewHolder>{

    private final List<String> veic;
    private final List<String> placa;
    private Context context;


    public VeiculosAdapter(Context context,List<String> veic,List<String> placa){
        this.context = context;
        this.placa = placa;
        this.veic = veic;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycle_veiculo, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(placa.get(i),veic.get(i));

    }

    @Override
    public int getItemCount() {
        return placa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(String placa,String veic) {
            TextView title = itemView.findViewById(R.id.textVeic);
            title.setText(placa);

            if(veic.equals("M")){
                ImageView iv = itemView.findViewById(R.id.imageVeic);
                iv.setImageResource(R.mipmap.moto);
            }else{
                ImageView iv = itemView.findViewById(R.id.imageVeic);
                iv.setImageResource(R.mipmap.carro);
            }

        }
    }
}
