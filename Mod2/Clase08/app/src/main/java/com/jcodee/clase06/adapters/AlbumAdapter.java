package com.jcodee.clase06.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jcodee.clase06.R;
import com.jcodee.clase06.activities.ImagenActivity;
import com.jcodee.clase06.net.response.album.Album;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Album> lista;

    public AlbumAdapter(Context context, ArrayList<Album> lista) {
        this.context = context;
        this.lista = lista;
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo;
        CardView contenedor;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            contenedor = itemView.findViewById(R.id.contenedor);
        }

        public void bind(Album album) {
            tvTitulo.setText(album.getTitle());
            contenedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ImagenActivity.class);
                    intent.putExtra("albumId", album.getId());
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_albunes, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AlbumViewHolder viewHolder = (AlbumViewHolder) holder;
        viewHolder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
