package com.jcodee.clase06.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jcodee.clase06.R;
import com.jcodee.clase06.activities.GaleriaActivity;
import com.jcodee.clase06.net.response.foto.Foto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    public static ArrayList<Foto> lista;

    public ImagenAdapter(Context context, ArrayList<Foto> lista) {
        this.context = context;
        this.lista = lista;
    }

    class ImagenViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagen;
        TextView tvTitulo;
        FrameLayout contenedor;

        public ImagenViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            contenedor = itemView.findViewById(R.id.contenedor);
        }

        public void bind(Foto foto, int position) {
            tvTitulo.setText(foto.getTitle());
            Picasso.get().load(foto.getUrl()).into(ivImagen);
            contenedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, GaleriaActivity.class);
                    intent.putExtra("position", position);
                    //intent.putExtra("lista", lista);
                    context.startActivity(intent);
                }
            });
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
        viewHolder.bind(lista.get(position), position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
