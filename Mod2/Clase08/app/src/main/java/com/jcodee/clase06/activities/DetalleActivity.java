package com.jcodee.clase06.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jcodee.clase06.R;
import com.jcodee.clase06.net.response.usuario.Usuario;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class DetalleActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private TextView tvUsuario, tvNombre, tvDireccion, tvEmail, tvPaginaWeb, tvCompania,
            tvCelular;
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
        tvCelular = findViewById(R.id.tvPhone);

        btnVerAlbunes = findViewById(R.id.btnVerAlbunes);
        btnVerPosts = findViewById(R.id.btnPosts);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Detalle");

        Usuario usuario = getIntent().getParcelableExtra("usuario");
        tvUsuario.setText(usuario.getUsername());
        tvCompania.setText(usuario.getCompany().getName());
        tvPaginaWeb.setText(usuario.getWebsite());
        tvEmail.setText(usuario.getEmail());
        tvDireccion.setText(usuario.getAddress().getCity());
        tvNombre.setText(usuario.getName());
        tvCelular.setText(usuario.getPhone());

        tvCelular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                methodRequiresCallPermission();
            }
        });

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
                Intent intent = new Intent(DetalleActivity.this, AlbunesActivity.class);
                intent.putExtra("id", usuario.getId());
                startActivity(intent);
            }
        });
        tvPaginaWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://" +
                        tvPaginaWeb.getText().toString()));
                startActivity(intent);
            }
        });
        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + tvEmail.getText().toString()));
                //startActivity(intent);
                startActivity(Intent.createChooser(intent, "Correo"));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private final int RC_CALL = 123;

    @AfterPermissionGranted(RC_CALL)
    private void methodRequiresCallPermission() {
        String[] perms = {Manifest.permission.CALL_PHONE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + tvCelular.getText().toString()));
            startActivity(intent);
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.call_required),
                    RC_CALL, perms);
        }
    }
}
