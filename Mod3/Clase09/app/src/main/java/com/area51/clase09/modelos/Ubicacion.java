package com.area51.clase09.modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Ubicacion implements Parcelable {
    private int id;
    private String direccion;
    private Double latitud, longitud;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.direccion);
        dest.writeValue(this.latitud);
        dest.writeValue(this.longitud);
    }

    public Ubicacion() {
    }

    protected Ubicacion(Parcel in) {
        this.id = in.readInt();
        this.direccion = in.readString();
        this.latitud = (Double) in.readValue(Double.class.getClassLoader());
        this.longitud = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Ubicacion> CREATOR = new Parcelable.Creator<Ubicacion>() {
        @Override
        public Ubicacion createFromParcel(Parcel source) {
            return new Ubicacion(source);
        }

        @Override
        public Ubicacion[] newArray(int size) {
            return new Ubicacion[size];
        }
    };
}
