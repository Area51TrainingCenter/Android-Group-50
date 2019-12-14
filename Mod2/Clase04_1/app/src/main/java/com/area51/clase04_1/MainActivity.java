package com.area51.clase04_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDatos;
    private FloatingActionButton fabAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDatos = findViewById(R.id.rvDatos);
        fabAgregar = findViewById(R.id.fabAgregar);


        fabAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        MainActivity.this, RegistroActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        SentenciaSQL sentenciaSQL = new SentenciaSQL(MainActivity.this);
        ArrayList<Persona> lista = sentenciaSQL.obtenerDatos();
        if (lista == null)
            lista = new ArrayList<>();
        Collections.reverse(lista);
        PersonaAdapter adapter = new PersonaAdapter(
                MainActivity.this, lista);
        rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //rvDatos.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        rvDatos.setAdapter(adapter);
    }
}
