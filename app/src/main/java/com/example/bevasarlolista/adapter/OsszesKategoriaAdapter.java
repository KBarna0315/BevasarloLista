package com.example.bevasarlolista.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bevasarlolista.OsszesKategoria;
import com.example.bevasarlolista.R;
import com.example.bevasarlolista.model.Kategoria;
import com.example.bevasarlolista.model.OsszesKategoriaModel;

import java.util.List;

public class OsszesKategoriaAdapter extends RecyclerView.Adapter<OsszesKategoriaAdapter.OsszesKategoriaViewHolder> {

    Context context;
    List<OsszesKategoriaModel> osszeskategoriaList;

    public OsszesKategoriaAdapter(Context context, List<OsszesKategoriaModel> kategoriaList) {
        this.context = context;
        this.osszeskategoriaList = kategoriaList;
    }

    @NonNull
    @Override
    public OsszesKategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.osszes_kategoria_row_items,parent,false);
        return new OsszesKategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OsszesKategoriaViewHolder holder, int position) {
        holder.kategoriaImage.setImageResource(osszeskategoriaList.get(position).getImageurl());


    }

    @Override
    public int getItemCount() {
        return osszeskategoriaList.size();
    }

    public static class OsszesKategoriaViewHolder extends  RecyclerView.ViewHolder{
        ImageView kategoriaImage;


        public OsszesKategoriaViewHolder(@NonNull View itemView) {
            super(itemView);

            kategoriaImage = itemView.findViewById(R.id.kategoriaImage);
        }
    }
}
