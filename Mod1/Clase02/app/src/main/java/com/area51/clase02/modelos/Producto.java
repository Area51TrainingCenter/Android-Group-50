package com.area51.clase02.modelos;

public class Producto {
    private String categoria;
    private String nombre;
    private String descripcion;
    private boolean isPublico;
    private boolean isAccept;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPublico() {
        return isPublico;
    }

    public void setPublico(boolean publico) {
        isPublico = publico;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }
}
