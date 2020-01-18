package com.jcodee.clase06.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jcodee.clase06.R;
import com.jcodee.clase06.net.response.usuario.Usuario;
import com.jcodee.clase06.activities.DetalleActivity;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Usuario> lista;

    public UsuarioAdapter(Context context, ArrayList<Usuario> lista) {
        this.context = context;
        this.lista = lista;
    }

    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDireccion, tvCelular, tvContador;
        CardView contenedor;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvCelular = itemView.findViewById(R.id.tvCelular);
            contenedor = itemView.findViewById(R.id.contenedor);
            tvContador = itemView.findViewById(R.id.tvContador);
        }

        public void bind(int position) {
            Usuario usuario = lista.get(position);
            tvContador.setText(String.valueOf(position + 1));
            tvNombre.setText(Html.fromHtml(
                    context.getString(R.string.template_nombre, usuario.getName())
            ));
            tvCelular.setText(Html.fromHtml(
                    context.getString(R.string.template_celular, usuario.getPhone())
            ));
            tvDireccion.setText(
                    Html.fromHtml(
                            context.getString(R.string.template_direccion, usuario.getAddress().getCity())
                    )
            );
            if ((position + 1) == 5) {
                contenedor.setAlpha(0.5f);
            }
            contenedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ((position + 1) != 5) {
                        Intent intent = new Intent(context, DetalleActivity.class);
                        intent.putExtra("usuario", usuario);
                        context.startActivity(intent);
                    }
                }
            });

            if (position % 2 == 0) {
                contenedor.setCardBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            } else {
                contenedor.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UsuarioViewHolder usuarioViewHolder = (UsuarioViewHolder) holder;
        usuarioViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
