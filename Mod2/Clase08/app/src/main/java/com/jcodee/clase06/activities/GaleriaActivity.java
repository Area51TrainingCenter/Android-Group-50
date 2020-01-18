package com.jcodee.clase06.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.jcodee.clase06.R;
import com.jcodee.clase06.adapters.GaleriaAdapter;
import com.jcodee.clase06.adapters.ImagenAdapter;
import com.jcodee.clase06.net.response.foto.Foto;

import java.util.ArrayList;
import java.util.Locale;

import me.relex.circleindicator.CircleIndicator;

public class GaleriaActivity extends AppCompatActivity {
    private GaleriaAdapter adapter;
    private ViewPager viewPager;
    private CircleIndicator indicator;
    private ImageView ivDerecha, ivIzquierda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);
        ivDerecha = findViewById(R.id.ivFlechaDe);
        ivIzquierda = findViewById(R.id.ivFlechaIz);

        adapter = new GaleriaAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        ArrayList<Foto> lista = ImagenAdapter.lista;//getIntent().getParcelableArrayListExtra("lista");

        adapter.agregarLista(lista);
        int position = getIntent().getIntExtra("position", 0);
        viewPager.setCurrentItem(position);
        indicator.setViewPager(viewPager);

        ivIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        ivDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

                Configuration config = new Configuration();
                config.locale = Locale.ENGLISH;
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());

                /*ListView listView = new ListView();
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView absListView, int i) {

                    }

                    @Override
                    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

                    }
                });

                 */

                //MediaPlayer mediaPlayer=MediaPlayer.create(GaleriaActivity.this,R.raw.audio);
                //mediaPlayer.start();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
