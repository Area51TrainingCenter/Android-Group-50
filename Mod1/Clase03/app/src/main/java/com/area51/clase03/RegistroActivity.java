package com.area51.clase03;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.facebook.drawee.view.SimpleDraweeView;

public class RegistroActivity extends AppCompatActivity {

    private EditText etNombre;
    private Spinner spTipo;
    private SimpleDraweeView sdvImagen1, sdvImagen2, sdvImagen3, sdvImagen4;
    private Button btnGuardar;

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

        sdvImagen1.setImageURI(Uri.parse("res:/" + R.drawable.imagen1));
        sdvImagen2.setImageURI(Uri.parse("res:/" + R.drawable.imagen2));
        sdvImagen3.setImageURI(Uri.parse("res:/" + R.drawable.imagen3));
        sdvImagen4.setImageURI(Uri.parse("res:/" + R.drawable.imagen4));


        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.tipos));
        spTipo.setAdapter(adapter);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();
                String tipo = spTipo.getSelectedItem().toString();
                

            }
        });
    }
}
