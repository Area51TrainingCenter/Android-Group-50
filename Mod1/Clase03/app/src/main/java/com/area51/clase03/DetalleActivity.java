package com.area51.clase03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class DetalleActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        viewPager = findViewById(R.id.viewPager);

        ImagenGaleriaAdapter adapter =
                new ImagenGaleriaAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        int posicion = getIntent().getIntExtra("posicion", 0);
        viewPager.setCurrentItem(posicion);
    }
}
