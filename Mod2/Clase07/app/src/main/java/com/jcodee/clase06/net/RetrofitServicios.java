package com.jcodee.clase06.net;

import com.jcodee.clase06.net.response.usuario.Usuario;
import com.jcodee.clase06.net.response.album.Album;
import com.jcodee.clase06.net.response.comentario.Comentario;
import com.jcodee.clase06.net.response.foto.Foto;
import com.jcodee.clase06.net.response.post.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitServicios {

    @GET("users")
    Call<ArrayList<Usuario>> obtenerUsuarios();

    @GET("posts")
    Call<ArrayList<Post>> obtenerPostPorUsuario(@Query("userId") int userId);

    @GET("posts/{id}/comments")
    Call<ArrayList<Comentario>> obtenerComentarioPorPost(@Path("id") int id);

    @GET("albums")
    Call<ArrayList<Album>> obtenerAlbumPorUsuario(@Query("userId") int userId);

    @GET("albums/{idAlbum}/photos")
    Call<ArrayList<Foto>> obtenerFotosPorAlbum(@Path("idAlbum") int idAlbum);

}
