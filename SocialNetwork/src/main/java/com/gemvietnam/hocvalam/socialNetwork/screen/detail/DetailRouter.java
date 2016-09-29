package com.gemvietnam.hocvalam.socialNetwork.screen.detail;

import com.gemvietnam.base.viper.Router;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;

/**
 * The Detail Router
 */
public class DetailRouter extends Router<DetailContract.Presenter> implements DetailContract.Router {

    public DetailRouter(ContainerView containerView) {
        super(containerView);
    }

    @Override
    public DetailContract.Presenter onCreatePresenter() {
        return new DetailPresenter(this);
    }

    public DetailRouter setFeed(Feed feed) {
        mPresenter.setFeed(feed);
        return this;
    }
}
