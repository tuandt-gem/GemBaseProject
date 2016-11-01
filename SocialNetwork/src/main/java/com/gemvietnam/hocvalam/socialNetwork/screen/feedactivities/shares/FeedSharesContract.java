package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.shares;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

/**
 * The FeedShares Contract
 */
interface FeedSharesContract {

  interface Interactor extends IInteractor<Presenter> {
  }

  interface View extends PresentView<Presenter> {
    void setSharesCount(int count);
  }

  interface Presenter extends IPresenter<View, Interactor> {
    FeedSharesPresenter setFeed(Feed feed);
  }
}



