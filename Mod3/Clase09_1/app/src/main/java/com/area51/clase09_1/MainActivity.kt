package com.area51.clase09_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.area51.clase09_1.database.MetodoSQL
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var adapter: UbicacionAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UbicacionAdapter(this)
        rvDatos.layoutManager = LinearLayoutManager(this)
        rvDatos.adapter = adapter

        fabAgregar.setOnClickListener {
            /*
            val = no cambia en el tiempo
            var = cambia en el tiempo
             */
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        val metodoSQL = MetodoSQL(this)
        adapter!!.agregar(metodoSQL.obtener())

    }
}
