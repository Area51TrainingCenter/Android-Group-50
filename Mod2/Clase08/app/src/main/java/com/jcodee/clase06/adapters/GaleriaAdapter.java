package com.jcodee.clase06.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jcodee.clase06.fragments.GaleriaFragment;
import com.jcodee.clase06.net.response.foto.Foto;

import java.util.ArrayList;

public class GaleriaAdapter extends FragmentPagerAdapter {
    private ArrayList<Foto> lista;

    public GaleriaAdapter(@NonNull FragmentManager fm) {
        super(fm);
        lista = new ArrayList<>();
    }

    public void agregarLista(ArrayList<Foto> datos) {
        lista.clear();
        lista.addAll(datos);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        GaleriaFragment fragment = new GaleriaFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        //bundle.putParcelableArrayList("lista", lista);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
