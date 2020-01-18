package com.jcodee.clase06.database.usuarios;

import com.jcodee.clase06.database.post.PostEntidad;
import com.jcodee.clase06.net.response.post.Post;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;

public class MetodoSQL {
    public boolean registrarUsuario(UsuarioEntidad entidad) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealm(entidad);
            realm.commitTransaction();
            return true;
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return false;
    }

    public RealmResults<UsuarioEntidad> obtenerUsuarios() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(UsuarioEntidad.class)
                .findAll();
    }

    public RealmResults<UsuarioEntidad> obtenerUsuarioPorNombre(String nombre) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(UsuarioEntidad.class)
                .contains("nombre", nombre, Case.INSENSITIVE)
                .findAll();
    }

    public void eliminarUsuarios() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.where(UsuarioEntidad.class).findAll().deleteAllFromRealm();
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

    public boolean registrarPost(PostEntidad entidad) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealm(entidad);
            realm.commitTransaction();
            return true;
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return false;
    }

    public RealmResults<PostEntidad> obtenerPost(int usuarioId) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(PostEntidad.class)
                .equalTo("idUsuario", usuarioId)
                .findAll();
    }
}
