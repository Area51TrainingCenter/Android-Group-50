package com.area51.clase05;

import io.realm.Realm;
import io.realm.RealmResults;

public class SentenciaSQL {

    public void registrar(Persona persona) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(persona);
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

    public RealmResults<Persona> obtenerTodos() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Persona.class).findAll();
    }

    public void eliminar(String id) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            Persona persona = realm.where(Persona.class)
                    .equalTo("id", id)
                    //.equalTo("nombre", "johann")
                    .findFirst();
            if (persona != null)
                persona.deleteFromRealm();
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }
}
