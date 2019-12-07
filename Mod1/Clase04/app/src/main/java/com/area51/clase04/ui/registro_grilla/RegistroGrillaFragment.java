package com.area51.clase04.ui.registro_grilla;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
import com.area51.clase04.Imagen;
import com.area51.clase04.Producto;
import com.area51.clase04.R;

import java.util.ArrayList;

public class RegistroGrillaFragment extends Fragment {

    private RegistroGrillaViewModel registroGrillaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registroGrillaViewModel =
                ViewModelProviders.of(this).get(RegistroGrillaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_registor_grilla, container, false);

        final Spinner spProducto = root.findViewById(R.id.spProducto);
        final EditText etImagen = root.findViewById(R.id.etImagen);
        final EditText etLink = root.findViewById(R.id.etLink);
        Button btnGuardar = root.findViewById(R.id.btnGuardar);

        ArrayList<String> productosValor = new ArrayList<>();
        for (Producto obj : AndroidApplication.listaProducto) {
            productosValor.add(obj.getNombre());
        }
        ArrayAdapter adapter = new ArrayAdapter(
                getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                productosValor
        );
        spProducto.setAdapter(adapter);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String producto = spProducto.getSelectedItem().toString();
                String imagen = etImagen.getText().toString();
                String link = etLink.getText().toString();

                Imagen obj = new Imagen();
                obj.setLink(link);
                obj.setNombre(imagen);
                obj.setProducto(producto);
                AndroidApplication.listaImagen.add(obj);

                hideKeyboardFrom(getContext(),etLink);

                Toast.makeText(getContext(),
                        "Se registro", Toast.LENGTH_SHORT).show();
                etImagen.setText("");
                etLink.setText("");
                etImagen.requestFocus();

            }
        });


        return root;
    }
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm =
                (InputMethodManager) context
                        .getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}