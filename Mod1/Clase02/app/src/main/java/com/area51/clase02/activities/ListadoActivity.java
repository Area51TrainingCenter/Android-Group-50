package com.area51.clase02.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.area51.clase02.ListadoAdapter;
import com.area51.clase02.R;
import com.area51.clase02.modelos.Producto;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {
    private Button agregar;
    private ListView lista;
    public static ArrayList<Producto> listaProductos;
    private ListadoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        agregar = findViewById(R.id.btnAgregar);
        lista = findViewById(R.id.lvLista);

        listaProductos = new ArrayList<>();


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Navegamos al otro activity
                Intent intent = new Intent(
                        ListadoActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        adapter = new ListadoAdapter(listaProductos, this);
        lista.setAdapter(adapter);
    }

    /*
    onCreate
    onStart
    onResume

    onPause
    onStop
    onRestart
    onDestroy
     */
}
