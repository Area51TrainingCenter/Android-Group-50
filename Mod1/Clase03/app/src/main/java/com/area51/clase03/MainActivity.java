package com.area51.clase03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gvDatos;
    private Button btnNuevo;
    public static ArrayList<Imagen> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvDatos = findViewById(R.id.gvDatos);
        btnNuevo = findViewById(R.id.btnNuevo);

        lista = new ArrayList<>();

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        MainActivity.this, RegistroActivity.class);
                startActivity(intent);

            }
        });

        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent =
                        new Intent(MainActivity.this, DetalleActivity.class);
                startActivity(intent);

            }
        });
    }

    ImagenAdapter adapter;

    @Override
    protected void onStart() {
        super.onStart();

        adapter = new ImagenAdapter(this, 0, lista);
        gvDatos.setAdapter(adapter);
    }

    public int cantidad() {
        return adapter.getCount();
    }
}
