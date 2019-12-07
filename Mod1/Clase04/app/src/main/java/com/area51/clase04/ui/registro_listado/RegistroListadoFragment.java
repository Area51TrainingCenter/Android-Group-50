package com.area51.clase04.ui.registro_listado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.area51.clase04.AndroidApplication;
import com.area51.clase04.Producto;
import com.area51.clase04.R;
import com.area51.clase04.Tipo;

import java.util.ArrayList;

public class RegistroListadoFragment extends Fragment {

    private RegistroListadoViewModel registroListadoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registroListadoViewModel =
                ViewModelProviders.of(this).get(RegistroListadoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registro_listado, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Spinner spTipo = view.findViewById(R.id.spTipo);
        final EditText etNombre = view.findViewById(R.id.etNombre);
        final EditText etDescripcion = view.findViewById(R.id.etDescripcion);
        final EditText etPrecio = view.findViewById(R.id.etPrecio);
        Button btnGuardar = view.findViewById(R.id.btnGuardar);

        ArrayList<String> tipoValores = new ArrayList<>();
        for (Tipo tipo : AndroidApplication.listaTipo) {
            tipoValores.add(tipo.getNombre());
        }
        ArrayAdapter adapter = new ArrayAdapter(
                getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                tipoValores
        );
        spTipo.setAdapter(adapter);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tipo = spTipo.getSelectedItem().toString();
                String nombre = etNombre.getText().toString();
                String descripcion = etDescripcion.getText().toString();
                String precio = etPrecio.getText().toString();

                Producto obj = new Producto();
                obj.setNombre(nombre);
                obj.setTipo(tipo);
                obj.setDescripcion(descripcion);
                obj.setPrecio(precio);
                AndroidApplication.listaProducto.add(obj);
                Toast.makeText(getContext(),
                        "Se registro", Toast.LENGTH_SHORT).show();
                spTipo.setSelection(0);
                etNombre.setText("");
                etDescripcion.setText("");
                etPrecio.setText("");
                etNombre.requestFocus();

            }
        });
    }
}