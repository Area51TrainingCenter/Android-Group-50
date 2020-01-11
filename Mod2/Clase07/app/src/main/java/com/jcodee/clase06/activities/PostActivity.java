package com.jcodee.clase06.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.jcodee.clase06.R;
import com.jcodee.clase06.Reusable;
import com.jcodee.clase06.adapters.PostAdapter;
import com.jcodee.clase06.database.post.PostEntidad;
import com.jcodee.clase06.database.usuarios.MetodoSQL;
import com.jcodee.clase06.net.response.post.Post;
import com.jcodee.clase06.net.RetrofitConfiguracion;
import com.jcodee.clase06.net.RetrofitServicios;

import java.util.ArrayList;

import io.realm.RealmResults;
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

        MetodoSQL metodoSQL = new MetodoSQL();
        if (Reusable.isOnline()) {
            Call<ArrayList<Post>> call = servicios.obtenerPostPorUsuario(userId);
            call.enqueue(new Callback<ArrayList<Post>>() {
                @Override
                public void onResponse(Call<ArrayList<Post>> call,
                                       Response<ArrayList<Post>> response) {

                    ArrayList<Post> list = response.body();

                    if (list != null && list.size() > 0) {
                        for (Post post : list) {
                            PostEntidad entidad = new PostEntidad();
                            entidad.setTitulo(post.getTitle());
                            entidad.setCuerpo(post.getBody());
                            entidad.setIdUsuario(userId);
                            metodoSQL.registrarPost(entidad);
                        }
                    }
/*
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:"+ latitude + "," + longitude));
                    startActivity(intent);
*/
                    adapter = new PostAdapter(PostActivity.this, list);
                    rvDatos.setLayoutManager(new LinearLayoutManager(PostActivity.this));
                    rvDatos.setAdapter(adapter);

                    Log.d("clase_log", response.toString());
                }

                @Override
                public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                }
            });
        } else {
            ArrayList<Post> list = new ArrayList<>();
            RealmResults<PostEntidad> posts = metodoSQL.obtenerPost(userId);
            for (PostEntidad item : posts) {
                Post post = new Post();
                post.setTitle(item.getTitulo());
                post.setBody(item.getCuerpo());
                list.add(post);
            }
            adapter = new PostAdapter(PostActivity.this, list);
            rvDatos.setLayoutManager(new LinearLayoutManager(PostActivity.this));
            rvDatos.setAdapter(adapter);
        }
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
