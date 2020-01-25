package com.area51.clase09_1.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteManage(context: Context) :
    SQLiteOpenHelper(context, "clase", null, 1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(
            "create table ubicaciones(" +
                    "id integer primary key autoincrement," +
                    "direccion text," +
                    "latitud decimal(17,2)," +
                    "longitud decimal(17,2))"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}