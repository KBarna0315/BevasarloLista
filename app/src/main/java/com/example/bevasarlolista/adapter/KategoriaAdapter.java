package com.example.bevasarlolista.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bevasarlolista.R;
import com.example.bevasarlolista.model.AkciosTermekek;
import com.example.bevasarlolista.model.Kategoria;

import java.util.List;

public class KategoriaAdapter extends RecyclerView.Adapter<KategoriaAdapter.KategoriaViewHolder> {

    Context context;
    List<Kategoria> kategoriaList;

    public KategoriaAdapter(Context context, List<Kategoria> kategoriaList) {
        this.context = context;
        this.kategoriaList = kategoriaList;
    }

    @NonNull
    @Override
    public KategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.kategoria_row_items,parent,false);
        return new KategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriaViewHolder holder, int position) {
        holder.kategoriaImage.setImageResource(kategoriaList.get(position).getImageurl());


    }

    @Override
    public int getItemCount() {
        return kategoriaList.size();
    }

    public static class KategoriaViewHolder extends  RecyclerView.ViewHolder{
        ImageView kategoriaImage;


        public KategoriaViewHolder(@NonNull View itemView) {
            super(itemView);

            kategoriaImage = itemView.findViewById(R.id.kategoriaImage);
        }
    }
}
