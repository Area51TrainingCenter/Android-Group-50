package com.jcodee.clase06.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.jcodee.clase06.R;
import com.jcodee.clase06.net.response.post.Post;
import com.jcodee.clase06.net.RetrofitConfiguracion;
import com.jcodee.clase06.net.RetrofitServicios;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        RetrofitServicios servicios = RetrofitConfiguracion.obtenerConfiguracion()
                .create(RetrofitServicios.class);

        int userId = getIntent().getIntExtra("id", 0);

        Call<ArrayList<Post>> call = servicios.obtenerPostPorUsuario(userId);
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call,
                                   Response<ArrayList<Post>> response) {
                Log.d("clase_log", response.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }
}
