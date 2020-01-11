package com.jcodee.clase06.database.usuarios;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UsuarioEntidad extends RealmObject {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private int idData;
    private String usuario;
    private String nombre;
    private String correo;
    private String celular;
    private String web;
    private DireccionEntidad direccion;
    private CompaniaEntidad compania;

    public int getIdData() {
        return idData;
    }

    public void setIdData(int idData) {
        this.idData = idData;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public DireccionEntidad getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionEntidad direccion) {
        this.direccion = direccion;
    }

    public CompaniaEntidad getCompania() {
        return compania;
    }

    public void setCompania(CompaniaEntidad compania) {
        this.compania = compania;
    }
}
