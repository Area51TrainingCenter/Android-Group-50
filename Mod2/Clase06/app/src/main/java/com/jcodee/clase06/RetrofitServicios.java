package com.jcodee.clase06;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitServicios {

    @GET("users")
    Call<ArrayList<Usuario>> obtenerUsuarios();
}
