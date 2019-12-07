package com.area51.clase03_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsuario, etContrasena;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuarioValor = etUsuario.getText().toString();
                String clave = etContrasena.getText().toString();

                ArrayList<Usuario> lista = AndroidApplication.lista;
                Usuario obj = null;
                if (lista.size() > 0) {
                    for (Usuario usuario : lista) {
                        if (usuarioValor.equals(usuario.getUsuario()) &&
                                clave.equals(usuario.getContrasena())) {
                            obj = usuario;
                            break;
                        }
                    }
                    if (obj == null) {
                        Toast.makeText(LoginActivity.this,
                                "Usuario no existe", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(LoginActivity.this, ListadoActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Usuario no existe", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
