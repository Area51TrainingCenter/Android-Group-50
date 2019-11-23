package com.area51.clase02.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.area51.clase02.ListadoAdapter;
import com.area51.clase02.R;
import com.area51.clase02.modelos.Producto;

import java.util.ArrayList;
import java.util.Collections;

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
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        lista.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int posicion, long l) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ListadoActivity.this);
                builder.setTitle("Opciones");
                builder.setMessage("Elegir una opción");
                builder.setCancelable(false);
                builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(ListadoActivity.this, MainActivity.class);
                        intent.putExtra("posicion", posicion);
                        startActivity(intent);

                    }
                });
                builder.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Producto obj = listaProductos.get(posicion);
                        adapter.eliminarObjeto(obj);
                        listaProductos.remove(obj);

                        Toast.makeText(ListadoActivity.this,
                                "Se elimino el registro", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNeutralButton("Mostrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Producto obj = listaProductos.get(posicion);
                        Intent intent = new Intent(ListadoActivity.this, DetalleActivity.class);
                        intent.putExtra("v_categoria", obj.getCategoria());
                        intent.putExtra("v_nombre", obj.getNombre());
                        intent.putExtra("v_detalle", obj.getDescripcion());
                        intent.putExtra("v_publico", obj.isPublico());
                        intent.putExtra("v_acepto", obj.isAccept());
                        startActivity(intent);

                    }
                });
                builder.show();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Collections.reverse(listaProductos);
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
