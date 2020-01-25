package com.area51.clase09.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteManage extends SQLiteOpenHelper {
    public SQLiteManage(@Nullable Context context) {
        super(context, "clase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table ubicaciones(" +
                        "id integer primary key autoincrement," +
                        "direccion text," +
                        "latitud decimal(10,7)," +
                        "longitud decimal(10,7))"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
