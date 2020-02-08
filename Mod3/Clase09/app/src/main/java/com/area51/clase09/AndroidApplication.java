package com.area51.clase09;

import android.app.Application;

import com.google.firebase.analytics.FirebaseAnalytics;

public class AndroidApplication extends Application {
    public static FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }
}
