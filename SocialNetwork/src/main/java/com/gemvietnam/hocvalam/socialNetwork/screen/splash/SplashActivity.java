package com.gemvietnam.hocvalam.socialNetwork.screen.splash;

import com.gemvietnam.common.base.log.Logger;
import com.gemvietnam.common.utils.DeviceUtils;
import com.gemvietnam.hocvalam.socialNetwork.R;
import com.gemvietnam.hocvalam.socialNetwork.screen.login.FakeLoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private static final int WAIT_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            if ((intent.getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
                // Activity was brought to front and not created,
                // Thus finishing this will get us to the last viewed activity
                finish();
                return;
            }
        }
        Logger.d("TAG", "DPI " + DeviceUtils.getDpi(this));
        Logger.d("TAG", "Screen size " + DeviceUtils.getDeviceSize(this).x + "x" + DeviceUtils.getDeviceSize(this).y);

        setContentView(R.layout.activity_splash);
        waitForSeconds();


    }

    /**
     * Splash wait time
     */
    private void waitForSeconds() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(WAIT_TIME);
                    goNextScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void goNextScreen() {
        startActivity(new Intent(this, FakeLoginActivity.class));
        finish();
    }
}
