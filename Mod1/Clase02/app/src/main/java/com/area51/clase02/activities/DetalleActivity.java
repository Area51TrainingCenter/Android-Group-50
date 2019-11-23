package com.area51.clase02.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.area51.clase02.R;

public class DetalleActivity extends AppCompatActivity {
    private TextView categoria, nombre, descripcion, publico, acepto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        categoria = findViewById(R.id.tvCategoria);
        nombre = findViewById(R.id.tvNombre);
        descripcion = findViewById(R.id.tvDescripcion);
        publico = findViewById(R.id.tvPublico);
        acepto = findViewById(R.id.tvAcepto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String categoriaValor = getIntent().getStringExtra("v_categoria");
        String nombreValor = getIntent().getStringExtra("v_nombre");
        String descripcionValor = getIntent().getStringExtra("v_detalle");
        Boolean publicoValor = getIntent().getBooleanExtra("v_publico", false);
        Boolean aceptoValor = getIntent().getBooleanExtra("v_acepto", false);

        categoria.setText(categoriaValor);
        nombre.setText(nombreValor);
        descripcion.setText(descripcionValor);
        publico.setText(String.valueOf(publicoValor));
        acepto.setText(String.valueOf(aceptoValor));

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
