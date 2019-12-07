package com.area51.clase04;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

public class AndroidApplication extends Application {
    public static ArrayList<Tipo> listaTipo;
    public static ArrayList<Imagen> listaImagen;
    public static ArrayList<Producto> listaProducto;

    @Override
    public void onCreate() {
        super.onCreate();

        listaImagen = new ArrayList<>();
        listaProducto = new ArrayList<>();
        listaTipo = new ArrayList<>();

        Fresco.initialize(this);
    }
}
