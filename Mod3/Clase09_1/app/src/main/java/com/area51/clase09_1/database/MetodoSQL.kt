package com.area51.clase09_1.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.area51.clase09_1.modelos.Ubicacion
import java.lang.Exception

class MetodoSQL(context: Context) {
    var database: SQLiteManage? = null

    init {
        database = SQLiteManage(context)
    }

    fun agregar(
        direccion: String,
        latitud: Double,
        longitud: Double
    ): Boolean {
        val db = database!!.writableDatabase
        try {
            db.beginTransaction()

            val values = ContentValues()
            values.put("direccion", direccion)
            values.put("latitud", latitud)
            values.put("longitud", longitud)
            db.insert("ubicaciones", null, values)

            db.setTransactionSuccessful()
            return true
        } catch (e: Exception) {

        } finally {
            db.endTransaction()
        }
        return false
    }

    fun obtener(): ArrayList<Ubicacion> {
        val db = database!!.readableDatabase
        val cursor = db.rawQuery(
            "select * from ubicaciones", null
        )
        val lista = ArrayList<Ubicacion>()
        if (cursor.moveToFirst()) {
            do {
                val ubicacion = Ubicacion()
                ubicacion.id = cursor.getInt(cursor.getColumnIndex("id"))
                ubicacion.direccion = cursor.getString(cursor.getColumnIndex("direccion"))
                ubicacion.latitud = cursor.getDouble(cursor.getColumnIndex("latitud"))
                ubicacion.longitud = cursor.getDouble(cursor.getColumnIndex("longitud"))
                lista.add(ubicacion)
            } while (cursor.moveToNext())
        }
        return lista
    }
}