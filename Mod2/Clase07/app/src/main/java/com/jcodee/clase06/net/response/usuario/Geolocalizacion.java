package com.jcodee.clase06.net.response.usuario;

import android.os.Parcel;
import android.os.Parcelable;

public class Geolocalizacion implements Parcelable {
    private String lat;
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.lat);
        dest.writeString(this.lng);
    }

    public Geolocalizacion() {
    }

    protected Geolocalizacion(Parcel in) {
        this.lat = in.readString();
        this.lng = in.readString();
    }

    public static final Parcelable.Creator<Geolocalizacion> CREATOR = new Parcelable.Creator<Geolocalizacion>() {
        @Override
        public Geolocalizacion createFromParcel(Parcel source) {
            return new Geolocalizacion(source);
        }

        @Override
        public Geolocalizacion[] newArray(int size) {
            return new Geolocalizacion[size];
        }
    };
}
