package com.jcodee.clase06.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.jcodee.clase06.R;
import com.jcodee.clase06.adapters.ImagenAdapter;
import com.jcodee.clase06.net.RetrofitConfiguracion;
import com.jcodee.clase06.net.RetrofitServicios;
import com.jcodee.clase06.net.response.foto.Foto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImagenActivity extends AppCompatActivity {
    private RecyclerView rvDatos;
    private ImagenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        rvDatos = findViewById(R.id.rvDatos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Fotos");

        int albumId = getIntent().getIntExtra("albumId", 0);

        RetrofitServicios servicios = RetrofitConfiguracion.obtenerConfiguracion()
                .create(RetrofitServicios.class);
        Call<ArrayList<Foto>> call = servicios.obtenerFotosPorAlbum(albumId);
        call.enqueue(new Callback<ArrayList<Foto>>() {
            @Override
            public void onResponse(Call<ArrayList<Foto>> call,
                                   Response<ArrayList<Foto>> response) {

                ArrayList<Foto> data = response.body();
                adapter = new ImagenAdapter(ImagenActivity.this, data);
                rvDatos.setLayoutManager(
                        new GridLayoutManager(
                                ImagenActivity.this, 2));
                rvDatos.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<Foto>> call, Throwable t) {

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
