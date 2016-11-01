package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.comments;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

/**
 * The FeedComments Contract
 */
interface FeedCommentsContract {

  interface Interactor extends IInteractor<Presenter> {
  }

  interface View extends PresentView<Presenter> {
    void setCommentsCount(int count);
  }

  interface Presenter extends IPresenter<View, Interactor> {
    FeedCommentsPresenter setFeed(Feed feed);
  }
}



