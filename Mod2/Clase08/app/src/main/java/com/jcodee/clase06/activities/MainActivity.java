package com.jcodee.clase06.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.jcodee.clase06.R;
import com.jcodee.clase06.Reusable;
import com.jcodee.clase06.database.usuarios.CompaniaEntidad;
import com.jcodee.clase06.database.usuarios.DireccionEntidad;
import com.jcodee.clase06.database.usuarios.GeolocalizacionEntidad;
import com.jcodee.clase06.database.usuarios.MetodoSQL;
import com.jcodee.clase06.database.usuarios.UsuarioEntidad;
import com.jcodee.clase06.net.response.usuario.Compania;
import com.jcodee.clase06.net.response.usuario.Direccion;
import com.jcodee.clase06.net.response.usuario.Geolocalizacion;
import com.jcodee.clase06.net.response.usuario.Usuario;
import com.jcodee.clase06.adapters.UsuarioAdapter;
import com.jcodee.clase06.net.RetrofitConfiguracion;
import com.jcodee.clase06.net.RetrofitServicios;

import java.util.ArrayList;

import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvDatos;
    private FrameLayout flCargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDatos = findViewById(R.id.rvDatos);
        flCargando = findViewById(R.id.flCargando);

        flCargando.setVisibility(View.VISIBLE);

        if (Reusable.isOnline()) {
            RetrofitServicios servicios =
                    RetrofitConfiguracion.obtenerConfiguracion()
                            .create(RetrofitServicios.class);
            Call<ArrayList<Usuario>> call =
                    servicios.obtenerUsuarios();
            call.enqueue(new Callback<ArrayList<Usuario>>() {
                @Override
                public void onResponse(Call<ArrayList<Usuario>> call,
                                       Response<ArrayList<Usuario>> response) {
                    Log.d("clase_06", response.toString());

                    MetodoSQL metodoSQL = new MetodoSQL();

                    ArrayList<Usuario> datos = response.body();
                    if (datos != null && datos.size() > 0) {
                        metodoSQL.eliminarUsuarios();
                        for (Usuario usuario : datos) {
                            UsuarioEntidad entidad = new UsuarioEntidad();
                            entidad.setIdData(usuario.getId());
                            entidad.setCelular(usuario.getPhone());
                            entidad.setNombre(usuario.getName());
                            CompaniaEntidad compania = new CompaniaEntidad();
                            compania.setNombre(usuario.getCompany().getName());
                            entidad.setCompania(compania);
                            entidad.setCorreo(usuario.getEmail());
                            DireccionEntidad direccion = new DireccionEntidad();
                            direccion.setDireccion(usuario.getAddress().getCity());
                            GeolocalizacionEntidad geolocalizacion = new GeolocalizacionEntidad();
                            geolocalizacion.setLatitud(usuario.getAddress().getGeo().getLat());
                            geolocalizacion.setLongitud(usuario.getAddress().getGeo().getLng());
                            direccion.setGeolocalizacion(geolocalizacion);
                            entidad.setDireccion(direccion);
                            entidad.setUsuario(usuario.getUsername());
                            entidad.setWeb(usuario.getWebsite());
                            metodoSQL.registrarUsuario(entidad);
                        }
                    }

                    UsuarioAdapter adapter =
                            new UsuarioAdapter(MainActivity.this, response.body());
                    rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rvDatos.setAdapter(adapter);
                    flCargando.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                    flCargando.setVisibility(View.GONE);
                }
            });
        } else {
            MetodoSQL metodoSQL = new MetodoSQL();
            RealmResults<UsuarioEntidad> usuarios = metodoSQL.obtenerUsuarios();

            ArrayList<Usuario> lista = new ArrayList<>();
            if (usuarios != null && usuarios.size() > 0) {
                for (UsuarioEntidad entidad : usuarios) {
                    Usuario usuario = new Usuario();
                    usuario.setId(entidad.getIdData());
                    usuario.setEmail(entidad.getCorreo());
                    usuario.setPhone(entidad.getCelular());
                    usuario.setName(entidad.getNombre());
                    usuario.setWebsite(entidad.getWeb());

                    Compania compania = new Compania();
                    compania.setName(entidad.getCompania().getNombre());
                    usuario.setCompany(compania);

                    Direccion direccion = new Direccion();
                    direccion.setCity(entidad.getDireccion().getDireccion());
                    Geolocalizacion geolocalizacion = new Geolocalizacion();
                    geolocalizacion.setLat(entidad.getDireccion()
                            .getGeolocalizacion().getLatitud());
                    geolocalizacion.setLng(entidad.getDireccion()
                            .getGeolocalizacion().getLongitud());
                    direccion.setGeo(geolocalizacion);
                    usuario.setAddress(direccion);

                    lista.add(usuario);
                }
            }

            UsuarioAdapter adapter =
                    new UsuarioAdapter(MainActivity.this, lista);
            rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            rvDatos.setAdapter(adapter);
            flCargando.setVisibility(View.GONE);
        }
    }
}
