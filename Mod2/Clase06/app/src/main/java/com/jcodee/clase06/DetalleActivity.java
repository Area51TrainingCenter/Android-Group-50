package com.jcodee.clase06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
    private TextView tvUsuario, tvNombre, tvDireccion, tvEmail, tvPaginaWeb, tvCompania;
    private Button btnVerAlbunes, btnVerPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        tvUsuario = findViewById(R.id.tvUsuario);
        tvNombre = findViewById(R.id.tvNombre);
        tvDireccion = findViewById(R.id.tvDireccion);
        tvEmail = findViewById(R.id.tvEmail);
        tvPaginaWeb = findViewById(R.id.tvWeb);
        tvCompania = findViewById(R.id.tvCompania);

        btnVerAlbunes = findViewById(R.id.btnVerAlbunes);
        btnVerPosts = findViewById(R.id.btnPosts);

        Usuario usuario = getIntent().getParcelableExtra("usuario");
        tvUsuario.setText(usuario.getUsername());
        tvCompania.setText(usuario.getCompany().getName());
        tvPaginaWeb.setText(usuario.getWebsite());
        tvEmail.setText(usuario.getEmail());
        tvDireccion.setText(usuario.getAddress().getCity());
        tvNombre.setText(usuario.getName());

        btnVerPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(DetalleActivity.this, PostActivity.class);
                intent.putExtra("id", usuario.getId());
                startActivity(intent);
            }
        });
        btnVerAlbunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
