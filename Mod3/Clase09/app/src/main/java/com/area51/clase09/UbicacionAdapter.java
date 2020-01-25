package com.area51.clase09;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.area51.clase09.modelos.Ubicacion;

import java.util.ArrayList;

public class UbicacionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Ubicacion> lista;

    public UbicacionAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    public void agregar(ArrayList<Ubicacion> datos) {
        lista.clear();
        lista.addAll(datos);
        notifyDataSetChanged();
    }

    class UbicacionViewHolder extends RecyclerView.ViewHolder {
        private CardView contenedor;
        private TextView tvUbicacion;

        public UbicacionViewHolder(@NonNull View itemView) {
            super(itemView);
            contenedor = itemView.findViewById(R.id.contenedor);
            tvUbicacion = itemView.findViewById(R.id.tvDireccion);
        }

        public void bind(final Ubicacion ubicacion) {
            tvUbicacion.setText(ubicacion.getDireccion());
            contenedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetalleActivity.class);
                    intent.putExtra("item", ubicacion);
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ubicacion,
                parent, false);
        return new UbicacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UbicacionViewHolder viewHolder = (UbicacionViewHolder) holder;
        viewHolder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
