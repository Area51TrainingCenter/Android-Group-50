package com.area51.clase01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
    private TextView nombre, apellido, edad, genero;
    private Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nombre = findViewById(R.id.tvNombre);
        apellido = findViewById(R.id.tvApellido);
        edad = findViewById(R.id.tvEdad);
        genero = findViewById(R.id.tvGenero);
        atras = findViewById(R.id.btnAtras);

        String nombreValor = getIntent().getStringExtra("nombre");
        String apellidoValor = getIntent().getStringExtra("apellido");
        String edadValor = getIntent().getStringExtra("edad");
        String generoValor = getIntent().getStringExtra("genero");

        nombre.setText(nombreValor);
        apellido.setText(apellidoValor);
        edad.setText(edadValor);
        genero.setText(generoValor);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //finish();

                onBackPressed();

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
