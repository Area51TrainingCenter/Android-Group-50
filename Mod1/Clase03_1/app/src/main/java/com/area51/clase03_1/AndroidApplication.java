package com.area51.clase03_1;

import android.app.Application;

import java.util.ArrayList;

public class AndroidApplication extends Application {
    public static ArrayList<Usuario> lista;

    @Override
    public void onCreate() {
        super.onCreate();

        lista = new ArrayList<>();
        if (lista.isEmpty()) {
            Usuario obj = new Usuario();
            obj.setUsuario("admin");
            obj.setNombre("Admin");
            obj.setContrasena("123");
            lista.add(obj);
        }
    }
}
