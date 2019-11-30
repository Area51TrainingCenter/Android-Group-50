package com.area51.clase03;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImagenFragment extends Fragment {

    private TextView tvNombre;
    private SimpleDraweeView sdvImagen;


    public ImagenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imagen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvNombre = view.findViewById(R.id.tvNombre);
        sdvImagen = view.findViewById(R.id.sdvImagen);

        int posicion = getArguments().getInt("posicion");
        Imagen obj = MainActivity.lista.get(posicion);
        tvNombre.setText(obj.getNombre());
        sdvImagen.setImageURI(Uri.parse(obj.getUrl()));
    }
}
