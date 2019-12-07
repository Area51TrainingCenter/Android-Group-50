package com.area51.clase03_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText etUsuario, etNombre, etClave, etRepClave;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etUsuario = findViewById(R.id.etUsuario);
        etNombre = findViewById(R.id.etNombre);
        etClave = findViewById(R.id.etClave);
        etRepClave = findViewById(R.id.etRepClave);
        btnGuardar = findViewById(R.id.btnGuardar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = etUsuario.getText().toString();
                String nombre = etNombre.getText().toString();
                String clave = etClave.getText().toString();
                String repClave = etRepClave.getText().toString();

                if (usuario.equals("")) {
                    etUsuario.setError("El campo usuario es requerido");
                    return;
                } else {
                    etUsuario.setError(null);
                }
                if (nombre.equals("")) {
                    etNombre.setError("El campo nombre es requerido");
                    return;
                } else {
                    etNombre.setError(null);
                }
                if (clave.equals("")) {
                    etClave.setError("El campo clave es requerido");
                    return;
                } else {
                    etClave.setError(null);
                }
                if (repClave.equals("")) {
                    etRepClave.setError("El campo rep clave es requerido");
                    return;
                } else {
                    etRepClave.setError(null);
                }
                if (!clave.equals(repClave)) {
                    etRepClave.setError("La clave debe de ser igual");
                    return;
                } else {
                    etRepClave.setError(null);
                }

                Usuario obj = new Usuario();
                obj.setUsuario(usuario);
                obj.setNombre(nombre);
                obj.setContrasena(clave);

                AndroidApplication.lista.add(obj);

                Toast.makeText(RegistroActivity.this,
                        "Se registro", Toast.LENGTH_SHORT).show();
                finish();

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
