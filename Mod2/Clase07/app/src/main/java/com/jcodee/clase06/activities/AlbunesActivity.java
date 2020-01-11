package com.jcodee.clase06.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.jcodee.clase06.R;
import com.jcodee.clase06.adapters.AlbumAdapter;
import com.jcodee.clase06.net.RetrofitConfiguracion;
import com.jcodee.clase06.net.RetrofitServicios;
import com.jcodee.clase06.net.response.album.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbunesActivity extends AppCompatActivity {
    private RecyclerView rvDatos;
    private AlbumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albunes);

        rvDatos = findViewById(R.id.rvDatos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Albunes");

        int usuarioId = getIntent().getIntExtra("id", 0);
        RetrofitServicios servicios = RetrofitConfiguracion.obtenerConfiguracion()
                .create(RetrofitServicios.class);
        Call<ArrayList<Album>> call = servicios.obtenerAlbumPorUsuario(usuarioId);
        call.enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call,
                                   Response<ArrayList<Album>> response) {
                adapter = new AlbumAdapter(AlbunesActivity.this,
                        response.body());
                rvDatos.setLayoutManager(new LinearLayoutManager(AlbunesActivity.this));
                rvDatos.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {
                Toast.makeText(AlbunesActivity.this, "Error - " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
