package com.gemvietnam.hocvalam.socialNetwork.screen.detail;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

/**
 * The Detail Contract
 */
interface DetailContract {

  interface Interactor extends IInteractor<Presenter> {
  }

  interface View extends PresentView<Presenter> {
    void viewFeedDetail(Feed feed);
  }

  interface Presenter extends IPresenter<View, Interactor> {
    DetailPresenter setFeed(Feed feed);
  }

}



