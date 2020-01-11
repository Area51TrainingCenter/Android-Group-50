package com.jcodee.clase06;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration =
                new RealmConfiguration.Builder()
                        .schemaVersion(1)
                        .name("clase07")
                        .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
