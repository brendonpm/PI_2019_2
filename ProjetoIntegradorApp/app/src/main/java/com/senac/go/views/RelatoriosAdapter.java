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

public class RelatoriosAdapter extends RecyclerView.Adapter<RelatoriosAdapter.ViewHolder> {

    private final List<String> veic;
    private final List<String> placa;
    private final List<String> postoCaro;
    private final List<String> postoBarato;
    private final List<String> media;
    private Context context;


    public RelatoriosAdapter(Context context,List<String> veic,List<String> placa,List<String> postoCaro,List<String> postoBarato,List<String> media){
        this.context = context;
        this.placa = placa;
        this.veic = veic;
        this.postoCaro = postoCaro;
        this.postoBarato = postoBarato;
        this.media = media;
    }

    @NonNull
    @Override
    public RelatoriosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RelatoriosAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycle_relat, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RelatoriosAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(placa.get(i),veic.get(i),postoCaro.get(i),postoBarato.get(i),media.get(i));

    }

    @Override
    public int getItemCount() {
        return placa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(String placa,String veic,String postoCaro,String postoBarato,String media) {
            TextView title = itemView.findViewById(R.id.textplacarelat);
            title.setText(placa);
            TextView title2 = itemView.findViewById(R.id.textpostcaro);
            title2.setText(postoCaro);
            TextView title3 = itemView.findViewById(R.id.textpostbarato);
            title3.setText(postoBarato);
            TextView title4 = itemView.findViewById(R.id.textmedia);
            title4.setText(media+" Km/L");

            if(veic.equals("M")){
                ImageView iv = itemView.findViewById(R.id.imageveicrelat);
                iv.setImageResource(R.mipmap.moto);
            }else{
                ImageView iv = itemView.findViewById(R.id.imageveicrelat);
                iv.setImageResource(R.mipmap.carro);
            }

        }
    }
}
