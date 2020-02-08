package com.area51.clase10;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface MetodoServicio {
    @Multipart
    @POST("url")
    Call<String> guardarImagen(@Part("file") MultipartBody.Part file,
                               @Part("nombre") RequestBody nombre);
}
