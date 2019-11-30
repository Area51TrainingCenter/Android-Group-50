package com.area51.clase03;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

public class RegistroActivity extends AppCompatActivity {

    private EditText etNombre;
    private Spinner spTipo;
    private SimpleDraweeView sdvImagen1, sdvImagen2, sdvImagen3, sdvImagen4,
            sdvBorde1, sdvBorde2, sdvBorde3, sdvBorde4;
    private Button btnGuardar;
    private String imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre = findViewById(R.id.etNombre);
        spTipo = findViewById(R.id.spTipo);
        sdvImagen1 = findViewById(R.id.sdvImagen1);
        sdvImagen2 = findViewById(R.id.sdvImagen2);
        sdvImagen3 = findViewById(R.id.sdvImagen3);
        sdvImagen4 = findViewById(R.id.sdvImagen4);
        btnGuardar = findViewById(R.id.btnGuardar);

        sdvBorde1 = findViewById(R.id.sdvBorde1);
        sdvBorde2 = findViewById(R.id.sdvBorde2);
        sdvBorde3 = findViewById(R.id.sdvBorde3);
        sdvBorde4 = findViewById(R.id.sdvBorde4);

        sdvImagen1.setImageURI(Uri.parse("res:/" + R.drawable.imagen1));
        sdvImagen2.setImageURI(Uri.parse("res:/" + R.drawable.imagen2));
        sdvImagen3.setImageURI(Uri.parse("res:/" + R.drawable.imagen3));
        sdvImagen4.setImageURI(Uri.parse("res:/" + R.drawable.imagen4));

        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.tipos));
        spTipo.setAdapter(adapter);

        sdvImagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imagen = "imagen1";
                sdvBorde1.setVisibility(View.VISIBLE);
                sdvBorde2.setVisibility(View.GONE);
                sdvBorde3.setVisibility(View.GONE);
                sdvBorde4.setVisibility(View.GONE);

            }
        });
        sdvImagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imagen = "imagen2";
                sdvBorde1.setVisibility(View.GONE);
                sdvBorde2.setVisibility(View.VISIBLE);
                sdvBorde3.setVisibility(View.GONE);
                sdvBorde4.setVisibility(View.GONE);

            }
        });
        sdvImagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imagen = "imagen3";
                sdvBorde1.setVisibility(View.GONE);
                sdvBorde2.setVisibility(View.GONE);
                sdvBorde3.setVisibility(View.VISIBLE);
                sdvBorde4.setVisibility(View.GONE);

            }
        });
        sdvImagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imagen = "imagen4";
                sdvBorde1.setVisibility(View.GONE);
                sdvBorde2.setVisibility(View.GONE);
                sdvBorde3.setVisibility(View.GONE);
                sdvBorde4.setVisibility(View.VISIBLE);

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();
                String tipo = spTipo.getSelectedItem().toString();

                if (nombre.equals("")) {
                    etNombre.setError("El campo es requerido");
                    return;
                } else {
                    etNombre.setError(null);
                }
                Imagen obj = new Imagen();
                obj.setNombre(nombre);
                obj.setTipo(tipo);

                int res = 0;
                if (imagen.equals("imagen1"))
                    res = R.drawable.imagen1;
                else if (imagen.equals("imagen2"))
                    res = R.drawable.imagen2;
                else if (imagen.equals("imagen3"))
                    res = R.drawable.imagen3;
                else if (imagen.equals("imagen4"))
                    res = R.drawable.imagen4;

                obj.setUrl("res:/" + res);

                MainActivity.lista.add(obj);
                Toast.makeText(RegistroActivity.this,
                        "Se registro", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
