package com.example.bevasarlolista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.example.bevasarlolista.adapter.KategoriaAdapter;
import com.example.bevasarlolista.adapter.OsszesKategoriaAdapter;
import com.example.bevasarlolista.model.Kategoria;
import com.example.bevasarlolista.model.OsszesKategoriaModel;

import java.util.ArrayList;
import java.util.List;

public class OsszesKategoria extends AppCompatActivity {

    RecyclerView osszesKategoriaRecyclerView;
    OsszesKategoriaAdapter osszesKategoriaAdapter;
    List<OsszesKategoriaModel> osszeskategoriaModelList;

    ImageView vissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osszes_kategoria);

    osszesKategoriaRecyclerView=findViewById(R.id.osszesKategoria);
    vissza=findViewById(R.id.vissza);


    //Csináljuk meg a nyilrabökésre a visszalépést a főoldalra
    vissza.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent vissza = new Intent(OsszesKategoria.this,MainActivity.class);
            startActivity(vissza);
            finish();
        }
    });

        //Kategória típusok hozzáadása hozzáadása a modellhez
        osszeskategoriaModelList=new ArrayList<>();
        osszeskategoriaModelList.add(new OsszesKategoriaModel(1, R.drawable.ic_cookies) );
        osszeskategoriaModelList.add(new OsszesKategoriaModel(2, R.drawable.ic_drink) );
        osszeskategoriaModelList.add(new OsszesKategoriaModel(3, R.drawable.ic_fruits) );
        osszeskategoriaModelList.add(new OsszesKategoriaModel(4, R.drawable.ic_meat) );
        osszeskategoriaModelList.add(new OsszesKategoriaModel(5, R.drawable.ic_veggies) );
        osszeskategoriaModelList.add(new OsszesKategoriaModel(6, R.drawable.ic_fish) );
        osszeskategoriaModelList.add(new OsszesKategoriaModel(7, R.drawable.ic_egg) );
        osszeskategoriaModelList.add(new OsszesKategoriaModel(8, R.drawable.ic_spices) );
        osszeskategoriaModelList.add(new OsszesKategoriaModel(9, R.drawable.ic_juce) );

       setKategoriaRecycler(osszeskategoriaModelList);
    }
    private void setKategoriaRecycler(List<OsszesKategoriaModel> osszesKategoriaModelList){
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,3);
        osszesKategoriaRecyclerView.setLayoutManager(layoutManager);
        osszesKategoriaRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4, dpToPx(16), true)); //dekoráció
        osszesKategoriaRecyclerView.setItemAnimator(new DefaultItemAnimator()); //dekoráció animátor
        osszesKategoriaAdapter = new OsszesKategoriaAdapter(this,osszesKategoriaModelList);
        osszesKategoriaRecyclerView.setAdapter(osszesKategoriaAdapter);
    }
    //Stackoveflowról lopott helyezést segítő cucccok
    //Segítenek a rácson belül helyezni a kategóriákat
    //Jobban elkülönülnek a boxok amiben benne vannak
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}