package com.area51.clase09;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.area51.clase09.database.MetodoSQL;

import java.io.IOException;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {
    private EditText etDireccion, etLatitud, etLongitud;
    private Button btnBuscar, btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etDireccion = findViewById(R.id.etDireccion);
        etLatitud = findViewById(R.id.etLatitud);
        etLongitud = findViewById(R.id.etLongitud);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String direccion = etDireccion.getText().toString();

                Geocoder geocoder = new Geocoder(RegistroActivity.this);
                try {
                    List<Address> direcciones =
                            geocoder.getFromLocationName(direccion, 1);
                    if (direcciones != null &&
                            direcciones.size() > 0) {
                        Address dire = direcciones.get(0);
                        etLatitud.setText(String.valueOf(dire.getLatitude()));
                        etLongitud.setText(String.valueOf(dire.getLongitude()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String direccion = etDireccion.getText().toString();
                String latitud = etLatitud.getText().toString();
                String longitud = etLongitud.getText().toString();

                MetodoSQL metodoSQL = new MetodoSQL(RegistroActivity.this);
                boolean seGrabo = metodoSQL.agregar(direccion,
                        Double.parseDouble(latitud),
                        Double.parseDouble(longitud));
                if (seGrabo) {
                    Toast.makeText(RegistroActivity.this,
                            "Se grabo la ubicación", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistroActivity.this,
                            "No se grabo", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
