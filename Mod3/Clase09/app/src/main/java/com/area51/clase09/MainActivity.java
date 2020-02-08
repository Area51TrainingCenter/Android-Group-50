package com.area51.clase09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.area51.clase09.database.MetodoSQL;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvDatos;
    private FloatingActionButton fabAgregar;
    private UbicacionAdapter adapter;
    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAnalytics=FirebaseAnalytics.getInstance(this);
        firebaseAnalytics.setCurrentScreen(this,"Main Activity","Main Detalle");

        rvDatos = findViewById(R.id.rvDatos);
        fabAgregar = findViewById(R.id.fabAgregar);

        adapter = new UbicacionAdapter(MainActivity.this);
        rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvDatos.setAdapter(adapter);

        fabAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "key_add");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Boton Agregar");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "text");
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);


                Intent intent =
                        new Intent(MainActivity.this,
                                RegistroActivity.class);
                startActivity(intent);



            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();


        MetodoSQL metodoSQL = new MetodoSQL(this);
        adapter.agregar(metodoSQL.obtener());
    }
}
