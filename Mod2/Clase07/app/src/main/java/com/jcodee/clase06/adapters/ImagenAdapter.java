package com.jcodee.clase06.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jcodee.clase06.R;
import com.jcodee.clase06.net.response.foto.Foto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Foto> lista;

    public ImagenAdapter(Context context, ArrayList<Foto> lista) {
        this.context = context;
        this.lista = lista;
    }

    class ImagenViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagen;
        TextView tvTitulo;

        public ImagenViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
        }

        public void bind(Foto foto) {
            tvTitulo.setText(foto.getTitle());
            Picasso.get().load(foto.getUrl()).into(ivImagen);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_imagen, parent, false);
        return new ImagenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImagenViewHolder viewHolder = (ImagenViewHolder) holder;
        viewHolder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
