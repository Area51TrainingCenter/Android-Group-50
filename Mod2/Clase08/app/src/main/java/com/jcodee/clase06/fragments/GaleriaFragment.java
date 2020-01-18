package com.jcodee.clase06.fragments;


import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodee.clase06.R;
import com.jcodee.clase06.adapters.ImagenAdapter;
import com.jcodee.clase06.net.response.foto.Foto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GaleriaFragment extends Fragment {
    private ImageView ivImagen;
    private TextView tvTitulo;


    public GaleriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_galeria, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivImagen = view.findViewById(R.id.ivImagen);
        tvTitulo = view.findViewById(R.id.tvTitulo);

        int position = getArguments().getInt("position", 0);
        ArrayList<Foto> lista = ImagenAdapter.lista;

        Foto foto = lista.get(position);

        Picasso.get().load(foto.getUrl()).into(ivImagen);
        tvTitulo.setText(foto.getTitle());
    }
}
