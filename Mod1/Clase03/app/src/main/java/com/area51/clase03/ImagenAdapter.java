package com.area51.clase03;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class ImagenAdapter extends ArrayAdapter<Imagen> {
    private Context context;
    private ArrayList<Imagen> lista;

    public ImagenAdapter(@NonNull Context context, int resource,
                         @NonNull ArrayList<Imagen> objects) {
        super(context, resource, objects);

        this.context = context;
        this.lista = objects;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.item_imagen, parent, false);

        SimpleDraweeView sdvImagen = convertView.findViewById(R.id.sdvImagen);
        TextView tvNombre = convertView.findViewById(R.id.tvNombre);

        Imagen obj = lista.get(position);
        sdvImagen.setImageURI(Uri.parse(obj.getUrl()));
        tvNombre.setText(obj.getNombre());

        return convertView;
    }
}
