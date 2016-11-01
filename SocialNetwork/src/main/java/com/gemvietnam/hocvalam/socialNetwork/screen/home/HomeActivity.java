package com.gemvietnam.hocvalam.socialNetwork.screen.home;

import com.gemvietnam.base.ContainerActivity;
import com.gemvietnam.base.viper.ViewFragment;
import com.gemvietnam.hocvalam.socialNetwork.screen.feeds.FeedsPresenter;

/**
 * Home Activity
 * Created by neo on 7/19/2016.
 */
public class HomeActivity extends ContainerActivity {
    @Override
    public ViewFragment onCreateFirstFragment() {
        return (ViewFragment) new FeedsPresenter(this).getFragment();
    }
}
