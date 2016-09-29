package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.Router;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;
import com.gemvietnam.hocvalam.socialNetwork.screen.detail.DetailRouter;

/**
 * Feeds Router
 * Created by neo on 9/15/2016.
 */
public class FeedsRouter extends Router<FeedsContract.Presenter> implements FeedsContract.Router {

    public FeedsRouter(ContainerView containerView) {
        super(containerView);
    }

    @Override
    public FeedsContract.Presenter onCreatePresenter() {
        return new FeedsPresenter(this);
    }

    @Override
    public void viewDetail(Feed feed) {
        new DetailRouter(mContainerView)
                .setFeed(feed)
                .present();
    }
}
