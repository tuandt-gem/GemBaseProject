package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 * Created by neo on 7/19/2016.
 */
interface FeedsContract {

  interface Interactor extends IInteractor<Presenter> {
    void getFeeds();
  }

  interface View extends PresentView<Presenter> {
    void loadFeeds(FeedAdapter feedAdapter);
  }

  interface Presenter extends IPresenter<View, Interactor> {
    void onFeedsLoaded(List<Feed> feeds);

    void navigateNewPost();
  }
}
