package com.jcodee.clase06.net.response.foto;

import android.os.Parcel;
import android.os.Parcelable;

public class Foto implements Parcelable {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.albumId);
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.thumbnailUrl);
    }

    public Foto() {
    }

    protected Foto(Parcel in) {
        this.albumId = in.readInt();
        this.id = in.readInt();
        this.title = in.readString();
        this.url = in.readString();
        this.thumbnailUrl = in.readString();
    }

    public static final Parcelable.Creator<Foto> CREATOR = new Parcelable.Creator<Foto>() {
        @Override
        public Foto createFromParcel(Parcel source) {
            return new Foto(source);
        }

        @Override
        public Foto[] newArray(int size) {
            return new Foto[size];
        }
    };
}
