package com.area51.clase09_1

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.area51.clase09_1.database.MetodoSQL
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btnAgregar.setOnClickListener {
            val direccion = etDireccion.text.toString()
            val latitud = etLatitud.text.toString()
            val longitud = etLongitud.text.toString()

            val metodoSQL = MetodoSQL(this)
            val resultado = metodoSQL.agregar(
                direccion,
                latitud.toDouble(), longitud.toDouble()
            )
            if (resultado) {
                Toast.makeText(
                    this, "se registro", Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this, "No se registro", Toast.LENGTH_SHORT
                ).show()
            }
            //https://sqlitebrowser.org
        }
        btnBuscar.setOnClickListener {
            val direccion = etDireccion.text.toString()

            val geocoder = Geocoder(this)
            val direcciones = geocoder.getFromLocationName(direccion, 1)
            if (direcciones != null &&
                direcciones.size > 0
            ) {
                val dir = direcciones[0]

                etLatitud.setText(dir.latitude.toString())
                etLongitud.setText(dir.longitude.toString())
            }
        }
    }
}
