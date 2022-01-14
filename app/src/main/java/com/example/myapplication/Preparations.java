package com.example.myapplication;

import android.app.Application;

import com.onesignal.OneSignal;

public class Preparations extends Application {
    private static final String ONESIGNAL_APP_ID = "9262478a-de9b-45a2-bc98-b5a728315a8c";


    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }

}
