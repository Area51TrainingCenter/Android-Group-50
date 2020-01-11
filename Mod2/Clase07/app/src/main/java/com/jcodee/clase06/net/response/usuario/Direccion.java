package com.jcodee.clase06.net.response.usuario;

import android.os.Parcel;
import android.os.Parcelable;

public class Direccion implements Parcelable {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geolocalizacion geo;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geolocalizacion getGeo() {
        return geo;
    }

    public void setGeo(Geolocalizacion geo) {
        this.geo = geo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.street);
        dest.writeString(this.suite);
        dest.writeString(this.city);
        dest.writeString(this.zipcode);
        dest.writeParcelable(this.geo, flags);
    }

    public Direccion() {
    }

    protected Direccion(Parcel in) {
        this.street = in.readString();
        this.suite = in.readString();
        this.city = in.readString();
        this.zipcode = in.readString();
        this.geo = in.readParcelable(Geolocalizacion.class.getClassLoader());
    }

    public static final Parcelable.Creator<Direccion> CREATOR = new Parcelable.Creator<Direccion>() {
        @Override
        public Direccion createFromParcel(Parcel source) {
            return new Direccion(source);
        }

        @Override
        public Direccion[] newArray(int size) {
            return new Direccion[size];
        }
    };
}
