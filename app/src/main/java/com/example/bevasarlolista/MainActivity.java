package com.example.bevasarlolista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bevasarlolista.adapter.AkciosTermekekAdapter;
import com.example.bevasarlolista.adapter.EppenMegtekintettAdapter;
import com.example.bevasarlolista.adapter.KategoriaAdapter;
import com.example.bevasarlolista.model.AkciosTermekek;
import com.example.bevasarlolista.model.EppenMegtekintett;
import com.example.bevasarlolista.model.Kategoria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView akciosRecyclerView,kategoriaRecyclerView,osszeskategoriaRecyclerView,eppenMegtekintettRecycler;
    AkciosTermekekAdapter akciosTermekekAdapter;
    List<AkciosTermekek> akciosTermekekList;

    KategoriaAdapter kategoriaAdapter;
    List<Kategoria> kategoriaList;

    EppenMegtekintettAdapter eppenMegtekintettAdapter;
    List<EppenMegtekintett> eppenMegtekintettList;

    ImageView osszesKategoria; //View volt eredetileg de talán így már lefut

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        akciosRecyclerView=findViewById(R.id.recyclerView);
        kategoriaRecyclerView=findViewById(R.id.kategoriaRecycler);
        osszesKategoria=findViewById(R.id.osszesKategoriaImage);
        eppenMegtekintettRecycler=findViewById(R.id.eppen_item); //Az elnevezés a Recyclerre utal ha nem is valami találó


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

        //Ide jön az Éppen megtekintett Last seen vagy hasonló hozzáadás
        eppenMegtekintettList=new ArrayList<>();
        eppenMegtekintettList.add(new EppenMegtekintett(
                "Görögdinnye",
                "Magas víztartalma miatt igen kedvelt nyáron!",
                "150 FT",
                "3",
                "KG",
                R.drawable.card4)
                );
        eppenMegtekintettList.add(new EppenMegtekintett(
                "Kiwi",
                "Finom gyümölcs vagy mi a fene!",
                "300 FT",
                "1",
                "db",
                R.drawable.card1)
                 );
        eppenMegtekintettList.add(new EppenMegtekintett(
                "Eper",
                "A magyar epernél nincs is jobb!",
                "1000 FT",
                "1",
                "KG",
                R.drawable.card2)
                );
        eppenMegtekintettList.add(new EppenMegtekintett(
                "Papaya",
                "Nem sokat tudok róla!",
                "600 FT",
                "1",
                "DB",
                R.drawable.card3)
                );


        //Meghívások
        setAkciosRecycler(akciosTermekekList);
        setKategoriaRecycler(kategoriaList);
        setEppenMegtekintettRecycler(eppenMegtekintettList);



    }
    //Akciós termékek
    private void setAkciosRecycler(List<AkciosTermekek> dataList){
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        akciosRecyclerView.setLayoutManager(layoutManager);
        akciosTermekekAdapter = new AkciosTermekekAdapter(this,dataList);
        akciosRecyclerView.setAdapter(akciosTermekekAdapter);
    }
    //Kategóriák megmutatása
    private void setKategoriaRecycler(List<Kategoria> kategoriaDataList){
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        kategoriaRecyclerView.setLayoutManager(layoutManager);
        kategoriaAdapter = new KategoriaAdapter(this,kategoriaDataList);
        kategoriaRecyclerView.setAdapter(kategoriaAdapter);
    }
    //Éppen megtekintett termékekhez
    private void setEppenMegtekintettRecycler(List<EppenMegtekintett> eppenMegtekintettList){
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        eppenMegtekintettRecycler.setLayoutManager(layoutManager);
        eppenMegtekintettAdapter = new EppenMegtekintettAdapter(this,eppenMegtekintettList);
        eppenMegtekintettRecycler.setAdapter(eppenMegtekintettAdapter);
    }
}
