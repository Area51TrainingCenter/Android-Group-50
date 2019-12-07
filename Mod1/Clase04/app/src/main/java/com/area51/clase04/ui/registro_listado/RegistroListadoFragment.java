package com.area51.clase04.ui.registro_listado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.area51.clase04.R;

public class RegistroListadoFragment extends Fragment {

    private RegistroListadoViewModel registroListadoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registroListadoViewModel =
                ViewModelProviders.of(this).get(RegistroListadoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registro_listado, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        registroListadoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}