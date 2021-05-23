package com.example.bevasarlolista.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bevasarlolista.R;
import com.example.bevasarlolista.TermekInformaciok;
import com.example.bevasarlolista.model.EppenMegtekintett;

import java.util.List;

public class EppenMegtekintettAdapter extends RecyclerView.Adapter<EppenMegtekintettAdapter.EppenMegtekintettViewHolder> {

    Context context;
    List<EppenMegtekintett> eppenMegtekintettList;

    public EppenMegtekintettAdapter(Context context,List<EppenMegtekintett> eppenMegtekintettList){
        this.context=context;
        this.eppenMegtekintettList=eppenMegtekintettList;

    }

    @NonNull
    @Override
    public EppenMegtekintettViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.eppen_megtekintett_termekek,parent,false);
        return new EppenMegtekintettViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EppenMegtekintettViewHolder holder, int position) {
        holder.nev.setText(eppenMegtekintettList.get(position).getNev());
        holder.leiras.setText(eppenMegtekintettList.get(position).getLeiras());
        holder.ar.setText(eppenMegtekintettList.get(position).getAr());
        holder.mennyiseg.setText(eppenMegtekintettList.get(position).getMennyiseg());
        holder.egysegar.setText(eppenMegtekintettList.get(position).getEgysegar());
        holder.bg.setBackgroundResource(eppenMegtekintettList.get(position).getImageURL());


        //Átíriányítás a termékinformációk activityre
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(context, TermekInformaciok.class);
                i.putExtra("nev",eppenMegtekintettList.get(position).getNev());
                i.putExtra("kep",eppenMegtekintettList.get(position).getBgimageurl());
                i.putExtra("ar",eppenMegtekintettList.get(position).getAr());
                i.putExtra("leiras",eppenMegtekintettList.get(position).getLeiras());

                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return eppenMegtekintettList.size();
    }

    public static class EppenMegtekintettViewHolder extends RecyclerView.ViewHolder{

        TextView nev,leiras,ar,mennyiseg,egysegar;
        ConstraintLayout bg;
       // ImageView eppenmegtekintettImageView;
        public EppenMegtekintettViewHolder(@NonNull View itemView) {
            super(itemView);

            nev=itemView.findViewById(R.id.termek_neve);
            leiras=itemView.findViewById(R.id.termek_leiras);
            ar=itemView.findViewById(R.id.termek_ara);
            mennyiseg=itemView.findViewById(R.id.termek_mennyiseg);
            egysegar=itemView.findViewById(R.id.termek_egyseg);
            bg=itemView.findViewById(R.id.eppen_layout);
        }
    }


}
