package com.jcodee.clase06;

import android.os.Parcel;
import android.os.Parcelable;

public class Compania implements Parcelable {
    private String name;
    private String catchPhrase;
    private String bs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.catchPhrase);
        dest.writeString(this.bs);
    }

    public Compania() {
    }

    protected Compania(Parcel in) {
        this.name = in.readString();
        this.catchPhrase = in.readString();
        this.bs = in.readString();
    }

    public static final Parcelable.Creator<Compania> CREATOR = new Parcelable.Creator<Compania>() {
        @Override
        public Compania createFromParcel(Parcel source) {
            return new Compania(source);
        }

        @Override
        public Compania[] newArray(int size) {
            return new Compania[size];
        }
    };
}
