package com.area51.clase04_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ManageSQL extends SQLiteOpenHelper {
    public ManageSQL(@Nullable Context context) {
        super(context, "clase04.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table persona (" +
                        "id integer primary key autoincrement," +
                        "nombre text," +
                        "apellido text," +
                        "edad text," +
                        "direccion text" +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int oldVersion, int newVersion) {
        if (oldVersion == 1) {
            sqLiteDatabase.execSQL(
                    "insert into persona(nombre,apellido,edad,direccion)" +
                            "values ('johann','jara','100','calle')"
            );
        }
    }
}
