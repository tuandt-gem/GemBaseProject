package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;

import java.util.List;

/**
 * Feeds Presenter
 * Created by neo on 7/19/2016.
 */
class FeedsPresenter extends Presenter<FeedsContract.Router, FeedsContract.ViewModel,
        FeedsContract.View, FeedsContract.Interactor> implements FeedsContract.Presenter {

    FeedsPresenter(FeedsContract.Router router) {
        super(router);
    }

    @Override
    public FeedsContract.ViewModel onCreateViewModel(FeedsContract.View view) {
        return new FeedViewModel(view);
    }

    @Override
    public FeedsContract.View onCreateView() {
        return FeedsFragment.getInstance();
    }

    @Override
    public void onFeedsLoaded(List<Feed> feeds) {
        mView.loadFeeds(mViewModel.setFeeds(feeds));
    }

    @Override
    public void start() {
        mInteractor.getFeeds();
    }

    @Override
    public FeedsContract.Interactor onCreateInteractor() {
        return new FeedsInteractor(this);
    }

    @Override
    public void viewDetail(Feed feed) {
        mRouter.viewDetail(feed);
    }
}
