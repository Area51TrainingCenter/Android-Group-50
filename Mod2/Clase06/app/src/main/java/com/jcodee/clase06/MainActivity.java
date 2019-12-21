package com.jcodee.clase06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvDatos;
    private FrameLayout flCargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDatos = findViewById(R.id.rvDatos);
        flCargando = findViewById(R.id.flCargando);

        flCargando.setVisibility(View.VISIBLE);

        RetrofitServicios servicios =
                RetrofitConfiguracion.obtenerConfiguracion()
                        .create(RetrofitServicios.class);
        Call<ArrayList<Usuario>> call =
                servicios.obtenerUsuarios();
        call.enqueue(new Callback<ArrayList<Usuario>>() {
            @Override
            public void onResponse(Call<ArrayList<Usuario>> call,
                                   Response<ArrayList<Usuario>> response) {
                Log.d("clase_06", response.toString());

                UsuarioAdapter adapter =
                        new UsuarioAdapter(MainActivity.this, response.body());
                rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rvDatos.setAdapter(adapter);
                flCargando.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                flCargando.setVisibility(View.GONE);
            }
        });
    }
}
