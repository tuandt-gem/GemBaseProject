package com.gemvietnam.hocvalam.socialNetwork;


import android.app.Application;

/**
 * Social network application
 * Created by neo on 7/18/2016.
 */
public class SocialNetworkApp extends Application {
    private static SocialNetworkApp sApp;

    public static SocialNetworkApp getInstance() {
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sApp = this;
    }
}
