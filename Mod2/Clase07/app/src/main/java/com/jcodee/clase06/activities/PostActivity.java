package com.jcodee.clase06.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.jcodee.clase06.R;
import com.jcodee.clase06.adapters.PostAdapter;
import com.jcodee.clase06.net.response.post.Post;
import com.jcodee.clase06.net.RetrofitConfiguracion;
import com.jcodee.clase06.net.RetrofitServicios;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {
    private RecyclerView rvDatos;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        rvDatos = findViewById(R.id.rvDatos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Post");

        RetrofitServicios servicios = RetrofitConfiguracion.obtenerConfiguracion()
                .create(RetrofitServicios.class);

        int userId = getIntent().getIntExtra("id", 0);

        Call<ArrayList<Post>> call = servicios.obtenerPostPorUsuario(userId);
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call,
                                   Response<ArrayList<Post>> response) {

                ArrayList<Post> list = response.body();
                adapter = new PostAdapter(PostActivity.this, list);
                rvDatos.setLayoutManager(new LinearLayoutManager(PostActivity.this));
                rvDatos.setAdapter(adapter);

                Log.d("clase_log", response.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
