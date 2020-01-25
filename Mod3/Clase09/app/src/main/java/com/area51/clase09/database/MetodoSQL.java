package com.area51.clase09.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.area51.clase09.modelos.Ubicacion;

import java.util.ArrayList;

public class MetodoSQL {
    private SQLiteManage sqLiteManage;

    public MetodoSQL(Context context) {
        sqLiteManage = new SQLiteManage(context);
    }

    public boolean agregar(String direccion,
                           Double latitud,
                           Double longitud) {
        SQLiteDatabase db = sqLiteManage.getWritableDatabase();

        try {
            db.beginTransaction();

            ContentValues values = new ContentValues();
            values.put("direccion", direccion);
            values.put("latitud", latitud);
            values.put("longitud", longitud);
            db.insert("ubicaciones", null, values);

            db.setTransactionSuccessful();
            return true;
        } catch (Exception e) {

        }
        finally {
            db.endTransaction();
        }
        return false;
    }

    public ArrayList<Ubicacion> obtener() {
        SQLiteDatabase db = sqLiteManage.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select * from ubicaciones", null
        );
        ArrayList<Ubicacion> lista = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Ubicacion ubicacion = new Ubicacion();
                ubicacion.setId(cursor.getInt(cursor.getColumnIndex("id")));
                ubicacion.setDireccion(cursor.getString(cursor.getColumnIndex("direccion")));
                ubicacion.setLatitud(cursor.getDouble(cursor.getColumnIndex("latitud")));
                ubicacion.setLongitud(cursor.getDouble(cursor.getColumnIndex("longitud")));

                lista.add(ubicacion);
            } while (cursor.moveToNext());
        }
        return lista;
    }
}
