package com.gemvietnam.hocvalam.socialNetwork.screen.detail;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.hocvalam.socialNetwork.model.Feed;

/**
 * The Detail Presenter
 */
class DetailPresenter extends Presenter<DetailContract.Router, DetailContract.ViewModel,
        DetailContract.View, DetailContract.Interactor> implements DetailContract.Presenter {

    DetailPresenter(DetailContract.Router router) {
        super(router);
    }

    @Override
    public DetailContract.ViewModel onCreateViewModel(DetailContract.View view) {
        return new DetailViewModel(view);
    }

    @Override
    public DetailContract.View onCreateView() {
        return DetailFragment.getInstance();
    }

    @Override
    public void start() {
        mView.viewFeedDetail(mViewModel);
    }

    @Override
    public DetailContract.Interactor onCreateInteractor() {
        return new DetailInteractor(this);
    }

    @Override
    public void setFeed(Feed feed) {
        mViewModel.setFeed(feed);
    }
}
