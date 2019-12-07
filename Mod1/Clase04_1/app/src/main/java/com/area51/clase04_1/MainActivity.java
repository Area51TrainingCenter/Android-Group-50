package com.area51.clase04_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SentenciaSQL sentenciaSQL = new SentenciaSQL(this);

        sentenciaSQL.registrar("johann", "jara",
                "100", "calle 2");

        for (Persona item : sentenciaSQL.obtenerDatos()) {
            Log.d("clase04_log",
                    "Nombre: " + item.getNombre() +
                            " Apellido: " + item.getApellido());
        }

    }
}
