package com.jcodee.clase06.net.response.usuario;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
    private int id;
    private String name;
    private String username;
    private String email;
    private Direccion address;
    private String phone;
    private String website;
    private Compania company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getAddress() {
        return address;
    }

    public void setAddress(Direccion address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Compania getCompany() {
        return company;
    }

    public void setCompany(Compania company) {
        this.company = company;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.username);
        dest.writeString(this.email);
        dest.writeParcelable(this.address, flags);
        dest.writeString(this.phone);
        dest.writeString(this.website);
        dest.writeParcelable(this.company, flags);
    }

    public Usuario() {
    }

    protected Usuario(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.username = in.readString();
        this.email = in.readString();
        this.address = in.readParcelable(Direccion.class.getClassLoader());
        this.phone = in.readString();
        this.website = in.readString();
        this.company = in.readParcelable(Compania.class.getClassLoader());
    }

    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel source) {
            return new Usuario(source);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}
