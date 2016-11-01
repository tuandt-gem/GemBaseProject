package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.likes;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

/**
 * The FeedLikes Contract
 */
interface FeedLikesContract {

  interface Interactor extends IInteractor<Presenter> {
  }

  interface View extends PresentView<Presenter> {
    void setLikesCount(int count);
  }

  interface Presenter extends IPresenter<View, Interactor> {
    FeedLikesPresenter setFeed(Feed feed);
  }
}



