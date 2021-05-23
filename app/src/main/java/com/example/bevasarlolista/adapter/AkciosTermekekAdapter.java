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

import java.util.List;

public class AkciosTermekekAdapter extends RecyclerView.Adapter<AkciosTermekekAdapter.AkciosTermekekViewHolder> {

    Context context;
    List<AkciosTermekek> akciosTermekekList;

    public AkciosTermekekAdapter(Context context, List<AkciosTermekek> akciosTermekekList) {
        this.context = context;
        this.akciosTermekekList = akciosTermekekList;
    }

    @NonNull
    @Override
    public AkciosTermekekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.akcios_row_items,parent,false);
        return new AkciosTermekekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AkciosTermekekViewHolder holder, int position) {

        holder.akciosImageView.setImageResource(akciosTermekekList.get(position).getImageurl());

    }

    @Override
    public int getItemCount() {
        return akciosTermekekList.size();

    }

    public static class AkciosTermekekViewHolder extends RecyclerView.ViewHolder{



        ImageView akciosImageView;
        public AkciosTermekekViewHolder(@NonNull View itemView) {
            super(itemView);

            akciosImageView=itemView.findViewById(R.id.kategoriaImage);
        }
    }

}
