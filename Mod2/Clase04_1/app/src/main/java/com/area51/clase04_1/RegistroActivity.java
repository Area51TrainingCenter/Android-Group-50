package com.area51.clase04_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegistroActivity extends AppCompatActivity {
    private TextInputEditText etNombre, etApellido, etEdad, etDireccion;
    private Button btnAgregar;
    private FrameLayout progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEdad = findViewById(R.id.etEdad);
        etDireccion = findViewById(R.id.etDireccion);
        btnAgregar = findViewById(R.id.btnAgregar);
        progress = findViewById(R.id.progress);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //TODO habilitar progress
        //progress.setVisibility(View.VISIBLE);

        if (getIntent().hasExtra("item")) {
            Persona item = getIntent().getParcelableExtra("item");
            etNombre.setText(item.getNombre());
            etApellido.setText(item.getApellido());
            etDireccion.setText(item.getDireccion());
            etEdad.setText(item.getEdad());

            btnAgregar.setTag(item.getId());
            btnAgregar.setText("Modificar");
        } else {
            btnAgregar.setTag(-1);
        }

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String edad = etEdad.getText().toString();
                String direccion = etDireccion.getText().toString();

                Persona persona = new Persona();
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEdad(edad);
                persona.setDireccion(direccion);

                SentenciaSQL sentenciaSQL = new SentenciaSQL(RegistroActivity.this);

                int id = (int) btnAgregar.getTag();
                if (id == -1) {
                    sentenciaSQL.registrar(persona);
                    Toast.makeText(RegistroActivity.this,
                            "Se registro", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    sentenciaSQL.actualizar(nombre, apellido, edad, direccion, id);
                    Toast.makeText(RegistroActivity.this,
                            "Se actualizo", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
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
