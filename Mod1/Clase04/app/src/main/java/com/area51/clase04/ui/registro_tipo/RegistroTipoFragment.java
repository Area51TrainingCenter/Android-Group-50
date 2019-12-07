package com.area51.clase04.ui.registro_tipo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.area51.clase04.AndroidApplication;
import com.area51.clase04.R;
import com.area51.clase04.Tipo;

public class RegistroTipoFragment extends Fragment {

    private RegistroTipoViewModel registroTipoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registroTipoViewModel =
                ViewModelProviders.of(this).get(RegistroTipoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registro_tipo, container, false);

        final EditText etTipo = root.findViewById(R.id.etTipo);
        Button btnGuardar = root.findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tipo = etTipo.getText().toString();

                Tipo obj = new Tipo();
                obj.setNombre(tipo);
                AndroidApplication.listaTipo.add(obj);
                Toast.makeText(getContext(),
                        "Se registro", Toast.LENGTH_SHORT).show();
                etTipo.setText("");
                etTipo.requestFocus();

            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}