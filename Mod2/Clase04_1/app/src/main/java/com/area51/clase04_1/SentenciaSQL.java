package com.area51.clase04_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class SentenciaSQL {
    private ManageSQL manageSQL;

    public SentenciaSQL(Context context) {
        manageSQL = new ManageSQL(context);
    }

    public void registrar(Persona persona) {

        SQLiteDatabase db = manageSQL.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", persona.getNombre());
        values.put("apellido", persona.getApellido());
        values.put("edad", persona.getEdad());
        values.put("direccion", persona.getDireccion());
        db.insert("persona", null, values);
    }

    public void registrar(String nombre, String apellido,
                          String edad, String direccion) {

        SQLiteDatabase db = manageSQL.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("apellido", apellido);
        values.put("edad", edad);
        values.put("direccion", direccion);
        db.insert("persona", null, values);
    }
//Realm, Live Data, Firebase
    public void actualizar(String nombre, String apellido,
                           String edad, String direccion, int id) {

        SQLiteDatabase db = manageSQL.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("apellido", apellido);
        values.put("edad", edad);
        values.put("direccion", direccion);
        db.update("persona", values, "id=?",
                new String[]{String.valueOf(id)});
    }

    public void eliminar(int id){
        SQLiteDatabase db = manageSQL.getWritableDatabase();
        db.delete("persona","id=?",
                new String[]{String.valueOf(id)});
    }

    public ArrayList<Persona> obtenerDatos() {
        SQLiteDatabase db = manageSQL.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select * from persona",
                null
        );
        ArrayList<Persona> lista = null;
        if (cursor.moveToFirst()) {
            lista = new ArrayList<>();
            do {
                Persona obj = new Persona();
                obj.setId(cursor.getInt(cursor.getColumnIndex("id")));
                obj.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                obj.setApellido(cursor.getString(cursor.getColumnIndex("apellido")));
                obj.setEdad(cursor.getString(cursor.getColumnIndex("edad")));
                obj.setDireccion(cursor.getString(cursor.getColumnIndex("direccion")));
                lista.add(obj);
            } while (cursor.moveToNext());
        }
        return lista;
    }


}
