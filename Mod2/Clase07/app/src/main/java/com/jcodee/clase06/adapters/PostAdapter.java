package com.jcodee.clase06.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jcodee.clase06.R;
import com.jcodee.clase06.net.response.post.Post;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Post> lista;

    public PostAdapter(Context context, ArrayList<Post> lista) {
        this.context = context;
        this.lista = lista;
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvDescripcion;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
        }

        public void bind(Post post) {
            tvTitulo.setText(post.getTitle());
            tvDescripcion.setText(post.getBody());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PostViewHolder viewHolder = (PostViewHolder) holder;
        viewHolder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
