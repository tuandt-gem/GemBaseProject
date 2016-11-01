package com.gemvietnam.hocvalam.socialNetwork;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

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

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }
}
