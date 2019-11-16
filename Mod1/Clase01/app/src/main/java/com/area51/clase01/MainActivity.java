package com.area51.clase01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView titulo;
    private EditText nombre, apellido;
    private Spinner edad;
    private RadioButton masculino, femenino;
    private Button mostrar;

    /*
    onCreate
    onStart
    onResume

    onPause
    onStop
    onDestroy

    onRestart
     */

    private void pintarLog(String mensaje) {
        Log.d("clase_android", mensaje);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //R.string.lbl_nombre

        titulo = findViewById(R.id.tvTitulo);
        nombre = findViewById(R.id.etNombre);
        apellido = findViewById(R.id.etApellido);
        edad = findViewById(R.id.spEdad);
        masculino = findViewById(R.id.rbMasculino);
        femenino = findViewById(R.id.rbFemenino);
        mostrar = findViewById(R.id.btnMostrar);

        titulo.setText("Formulario");

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,
                        "Se selecciono", Toast.LENGTH_SHORT).show();

            }
        });

        pintarLog("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        pintarLog("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        pintarLog("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        pintarLog("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        pintarLog("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pintarLog("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        pintarLog("onRestart");
    }
}
