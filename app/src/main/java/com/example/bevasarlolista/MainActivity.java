package com.example.bevasarlolista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bevasarlolista.adapter.AkciosTermekekAdapter;
import com.example.bevasarlolista.adapter.KategoriaAdapter;
import com.example.bevasarlolista.model.AkciosTermekek;
import com.example.bevasarlolista.model.Kategoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView akciosRecyclerView,kategoriaRecyclerView;
    AkciosTermekekAdapter akciosTermekekAdapter;
    List<AkciosTermekek> akciosTermekekList;

    KategoriaAdapter kategoriaAdapter;
    List<Kategoria> kategoriaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        akciosRecyclerView=findViewById(R.id.recyclerView);
        kategoriaRecyclerView=findViewById(R.id.kategoriaRecycler);


        //Termékek hozzáadása a modelhez
        akciosTermekekList=new ArrayList<>();
        akciosTermekekList.add(new AkciosTermekek(1, R.drawable.discountberry) );
        akciosTermekekList.add(new AkciosTermekek(2, R.drawable.discountbrocoli) );
        akciosTermekekList.add(new AkciosTermekek(3, R.drawable.discountmeat) );
        akciosTermekekList.add(new AkciosTermekek(4, R.drawable.discountberry) );
        akciosTermekekList.add(new AkciosTermekek(5, R.drawable.discountbrocoli) );
        akciosTermekekList.add(new AkciosTermekek(6, R.drawable.discountmeat) );

        //Kategória típusok hozzáadása hozzáadása a modelhez
        kategoriaList=new ArrayList<>();
        kategoriaList.add(new Kategoria(1, R.drawable.ic_home_fish) );
        kategoriaList.add(new Kategoria(1, R.drawable.ic_home_fruits) );
        kategoriaList.add(new Kategoria(1, R.drawable.ic_home_meats) );
        kategoriaList.add(new Kategoria(1, R.drawable.ic_home_veggies) );

        setAkciosRecycler(akciosTermekekList);
        setKategoriaRecycler(kategoriaList);


    }
    private void setAkciosRecycler(List<AkciosTermekek> dataList){
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        akciosRecyclerView.setLayoutManager(layoutManager);
        akciosTermekekAdapter = new AkciosTermekekAdapter(this,dataList);
        akciosRecyclerView.setAdapter(akciosTermekekAdapter);
    }
    private void setKategoriaRecycler(List<Kategoria> kategoriaDataList){
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        kategoriaRecyclerView.setLayoutManager(layoutManager);
        kategoriaAdapter = new KategoriaAdapter(this,kategoriaDataList);
        kategoriaRecyclerView.setAdapter(kategoriaAdapter);
    }
}
//41:00 Új activityt kéne létrehozni