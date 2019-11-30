package com.area51.clase03;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ImagenGaleriaAdapter extends FragmentPagerAdapter {

    public ImagenGaleriaAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ImagenFragment fragment = new ImagenFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("posicion", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return MainActivity.lista.size();
    }
}
