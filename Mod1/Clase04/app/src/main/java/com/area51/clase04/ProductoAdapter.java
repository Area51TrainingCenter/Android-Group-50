package com.area51.clase04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> lista;

    public ProductoAdapter(Context context, ArrayList<Producto> lista) {
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
                .inflate(R.layout.item_producto, viewGroup, false);

        TextView tvNombre, tvTipo, tvPrecio;
        tvNombre = view.findViewById(R.id.tvProducto);
        tvTipo = view.findViewById(R.id.tvTipo);
        tvPrecio = view.findViewById(R.id.tvPrecio);

        Producto obj=lista.get(i);
        tvNombre.setText(obj.getNombre());
        tvPrecio.setText(obj.getPrecio());//String.valueOf(obj.getPrecio())
        tvTipo.setText(obj.getTipo());

        return view;
    }
}
