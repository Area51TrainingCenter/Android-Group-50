package com.area51.clase03;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
