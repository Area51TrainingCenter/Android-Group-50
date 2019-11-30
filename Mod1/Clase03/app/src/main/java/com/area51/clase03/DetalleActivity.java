package com.area51.clase03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import me.relex.circleindicator.CircleIndicator;

public class DetalleActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ImageView ivIzquierda, ivDerecha;
    private CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        viewPager = findViewById(R.id.viewPager);
        ivIzquierda = findViewById(R.id.ivIzquierda);
        ivDerecha = findViewById(R.id.ivDerecha);
        indicator = findViewById(R.id.indicator);

        ImagenGaleriaAdapter adapter =
                new ImagenGaleriaAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        int posicion = getIntent().getIntExtra("posicion", 0);
        viewPager.setCurrentItem(posicion);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
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
            }
        });
    }
}
