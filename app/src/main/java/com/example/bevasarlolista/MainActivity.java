package com.example.bevasarlolista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bevasarlolista.adapter.AkciosTermekekAdapter;
import com.example.bevasarlolista.adapter.KategoriaAdapter;
import com.example.bevasarlolista.model.AkciosTermekek;
import com.example.bevasarlolista.model.Kategoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView akciosRecyclerView,kategoriaRecyclerView,osszeskategoriaRecyclerView;
    AkciosTermekekAdapter akciosTermekekAdapter;
    List<AkciosTermekek> akciosTermekekList;

    KategoriaAdapter kategoriaAdapter;
    List<Kategoria> kategoriaList;

    View osszesKategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        akciosRecyclerView=findViewById(R.id.recyclerView);
        kategoriaRecyclerView=findViewById(R.id.kategoriaRecycler);
        osszesKategoria=findViewById(R.id.osszesKategoriaImage);

        //2.nézetnél megnézhetjük az összes kilistázott kategóriát
        osszesKategoria.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                Intent i = new Intent(MainActivity.this,OsszesKategoria.class);
                startActivity(i);
            }
        });



        //Termékek hozzáadása a modellhez
        //A képeket az internetről szedtem átméreteztem és felhasználtam őket
        akciosTermekekList=new ArrayList<>();
        akciosTermekekList.add(new AkciosTermekek(1, R.drawable.discountberry) );
        akciosTermekekList.add(new AkciosTermekek(2, R.drawable.discountbrocoli) );
        akciosTermekekList.add(new AkciosTermekek(3, R.drawable.discountmeat) );
        akciosTermekekList.add(new AkciosTermekek(4, R.drawable.discountberry) );
        akciosTermekekList.add(new AkciosTermekek(5, R.drawable.discountbrocoli) );
        akciosTermekekList.add(new AkciosTermekek(6, R.drawable.discountmeat) );

        //Kategória típusok hozzáadása hozzáadása a modellhez
        kategoriaList=new ArrayList<>();
        kategoriaList.add(new Kategoria(1, R.drawable.ic_home_fish) );
        kategoriaList.add(new Kategoria(2, R.drawable.ic_home_fruits) );
        kategoriaList.add(new Kategoria(3, R.drawable.ic_home_meats) );
        kategoriaList.add(new Kategoria(4, R.drawable.ic_home_veggies) );

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
