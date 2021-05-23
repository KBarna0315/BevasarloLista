package com.example.bevasarlolista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TermekInformaciok extends AppCompatActivity {

    ImageView img,vissza;
    TextView proNev,proAr,proLeiras,proMenny,proEgys;
    String nev,ar,leiras,mennyiseg,egyseg;
    Integer image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termek_informaciok);

        Intent i = getIntent();

        nev = i.getStringExtra("nev");
        image = i.getIntExtra("image",R.drawable.b2);
        ar = i.getStringExtra("ar");
        leiras = i.getStringExtra("leiras");
        mennyiseg=i.getStringExtra("mennyiseg");
        egyseg=i.getStringExtra("egyseg");


        proNev=findViewById(R.id.termek_neve);
        img=findViewById(R.id.nagy_kep);
        vissza=findViewById(R.id.vissza2);
        proAr=findViewById(R.id.termek_ara);
        proLeiras=findViewById(R.id.termek_leiras);
        proMenny=findViewById(R.id.termek_mennyiseg);
        proEgys=findViewById(R.id.termek_egyseg);

        proNev.setText(nev);
        proAr.setText(ar);
        proLeiras.setText(leiras);
        proMenny.setText(mennyiseg);
        proEgys.setText(egyseg);
        img.setImageResource(image);

        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TermekInformaciok.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}