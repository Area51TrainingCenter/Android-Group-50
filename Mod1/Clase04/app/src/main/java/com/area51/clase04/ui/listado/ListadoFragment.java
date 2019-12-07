package com.area51.clase04.ui.listado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.area51.clase04.AndroidApplication;
import com.area51.clase04.ProductoAdapter;
import com.area51.clase04.R;

public class ListadoFragment extends Fragment {

    private ListadoViewModel listadoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listadoViewModel =
                ViewModelProviders.of(this).get(ListadoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_listado, container, false);

        ListView lvLista = root.findViewById(R.id.lvLista);

        ProductoAdapter adapter =
                new ProductoAdapter(getContext(), AndroidApplication.listaProducto);
        lvLista.setAdapter(adapter);

        return root;
    }
}