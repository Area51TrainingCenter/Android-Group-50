package com.area51.clase02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.area51.clase02.modelos.Producto;

import java.util.ArrayList;

public class ListadoAdapter extends BaseAdapter {
    private ArrayList<Producto> lista;
    private Context context;

    public ListadoAdapter(ArrayList<Producto> lista, Context context) {
        this.lista = lista;
        this.context = context;
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
                .inflate(R.layout.item_listado, viewGroup, false);

        TextView categoria = view.findViewById(R.id.tvCategoria);
        TextView nombre = view.findViewById(R.id.tvNombre);
        TextView descripcion = view.findViewById(R.id.tvDescripcion);
        TextView publico = view.findViewById(R.id.tvPublico);

        Producto obj = (Producto) getItem(i);
        categoria.setText(obj.getCategoria());
        nombre.setText(obj.getNombre());
        descripcion.setText(obj.getDescripcion());
        publico.setText(String.valueOf(obj.isPublico()));

        if(!obj.isAccept()){
            descripcion.setVisibility(View.GONE);
            publico.setVisibility(View.GONE);

            /*
            VISIBLE = visible
            INVISIBLE = invisible
            GONE = invisible, pero sin ocupar espacio
             */
        }

        return view;
    }

    public void eliminarObjeto(Producto obj) {
        lista.remove(obj);
        notifyDataSetChanged();
    }
}
