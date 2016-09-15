package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.Interactor;
import com.gemvietnam.hocvalam.socialNetwork.network.dto.Feed;

import java.util.ArrayList;
import java.util.List;

/**
 * Feeds interactor
 * Created by neo on 9/15/2016.
 */
public class FeedsInteractor extends Interactor<FeedsContract.Presenter> implements FeedsContract
        .Interactor {

    public FeedsInteractor(FeedsContract.Presenter presenter) {
        super(presenter);
    }

    @Override
    public void getFeeds() {
        List<Feed> feeds = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            feeds.add(Feed.getInstance());
        }

        mPresenter.onFeedsLoaded(feeds);
    }
}