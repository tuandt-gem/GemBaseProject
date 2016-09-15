package com.gemvietnam.hocvalam.socialNetwork.screen.home;

import com.gemvietnam.base.BaseActivity;
import com.gemvietnam.base.ContainerActivity;
import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.screen.feeds.FeedsRouter;

import android.app.Activity;

/**
 * Home Activity
 * Created by neo on 7/19/2016.
 */
public class HomeActivity extends ContainerActivity {
    @Override
    public ViewFragment onCreateFirstFragment() {
        return (ViewFragment) new FeedsRouter(this).getView();
    }


    @Override
    public BaseActivity getBaseActivity() {
        return null;
    }


    @Override
    public Activity getViewContext() {
        return null;
    }
}
