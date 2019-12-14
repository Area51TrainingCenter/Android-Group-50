package com.area51.clase05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SentenciaSQL sentenciaSQL = new SentenciaSQL();

        Persona persona = new Persona();
        persona.setNombre("Johann");
        persona.setApellido("Jara");
        persona.setEdad("100");
        persona.setDireccion("calle las flores");
        sentenciaSQL.registrar(persona);

        RealmResults<Persona> lista = sentenciaSQL.obtenerTodos();
        for (Persona item : lista) {
            Log.d("tag_clase05", "Nombre: " + item.getNombre());
        }
    }
}
