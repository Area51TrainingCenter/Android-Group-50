package com.area51.clase01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        masculino.setChecked(true);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obtenemos los valores de los componentes
                String nombreValor = nombre.getText().toString();
                String apellidoValor = apellido.getText().toString();
                String edadValor = edad.getSelectedItem().toString();
                boolean masculinoValor = masculino.isChecked();
                boolean femeninoValor = femenino.isChecked();

                if (nombreValor.equals("")) {
                    nombre.setError("El campo es requerido");
                    return;
                } else {
                    nombre.setError(null);
                }
                if (apellidoValor.equals("")) {
                    apellido.setError("El campo es requerido");
                    return;
                } else {
                    apellido.setError(null);
                }

                Toast.makeText(MainActivity.this,
                        "Nombre: " + nombreValor +
                                "\nApellido: " + apellidoValor +
                                "\nEdad: " + edadValor +
                                "\nGenero: " + (masculinoValor ? "Masculino" :
                                (femeninoValor ? "Femenino" : "")),
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,
                        DetalleActivity.class);

                intent.putExtra("nombre", nombreValor);
                intent.putExtra("apellido", apellidoValor);
                intent.putExtra("edad", edadValor);
                intent.putExtra("genero", (masculinoValor ? "Masculino" :
                        (femeninoValor ? "Femenino" : "")));

                startActivity(intent);

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
