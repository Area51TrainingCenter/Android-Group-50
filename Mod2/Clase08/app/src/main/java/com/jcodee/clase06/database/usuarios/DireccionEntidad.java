package com.jcodee.clase06.database.usuarios;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DireccionEntidad extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String direccion;
    private GeolocalizacionEntidad geolocalizacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public GeolocalizacionEntidad getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(GeolocalizacionEntidad geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }
}
