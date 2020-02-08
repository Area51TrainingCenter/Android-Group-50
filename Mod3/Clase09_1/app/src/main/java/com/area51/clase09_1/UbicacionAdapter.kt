package com.area51.clase09_1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.area51.clase09_1.modelos.Ubicacion
import kotlinx.android.synthetic.main.item_ubicacion.view.*

class UbicacionAdapter(val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var lista = ArrayList<Ubicacion>()

    inner class UbicacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(ubicacion: Ubicacion) {
            itemView.tvDireccion.text = ubicacion.direccion

            itemView.contenedor.setOnClickListener {
                val intent = Intent(context, MapsActivity::class.java)
                intent.putExtra("latitud", ubicacion.latitud)
                intent.putExtra("longitud", ubicacion.longitud)
                intent.putExtra("direccion", ubicacion.direccion)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_ubicacion, parent, false)
        return UbicacionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as UbicacionViewHolder
        viewHolder.bind(lista[position])
    }

    fun agregar(datos: ArrayList<Ubicacion>) {
        lista.clear()
        lista.addAll(datos)
        notifyDataSetChanged()
    }
}