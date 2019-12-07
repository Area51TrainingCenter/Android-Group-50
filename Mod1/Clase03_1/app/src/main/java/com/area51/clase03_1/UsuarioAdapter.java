package com.area51.clase03_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UsuarioAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Usuario> lista;

    public UsuarioAdapter(Context context, ArrayList<Usuario> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context)
                .inflate(R.layout.item_usuario, viewGroup, false);

        TextView tvUsuario, tvNombre;

        tvUsuario = view.findViewById(R.id.tvUsuario);
        tvNombre = view.findViewById(R.id.tvNombre);

        Usuario obj = lista.get(i);
        tvUsuario.setText(obj.getUsuario());
        tvNombre.setText(obj.getNombre());

        return view;
    }
}
