package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.Router;
import com.gemvietnam.base.viper.interfaces.ContainerView;

/**
 * Feeds Router
 * Created by neo on 9/15/2016.
 */
public class FeedsRouter extends Router<FeedsContract.View> implements FeedsContract.Router {
    public FeedsRouter(ContainerView containerView) {
        super(containerView);
    }

    @Override
    public FeedsContract.View onCreateView() {
        return FeedsFragment.getInstance();
    }
}
