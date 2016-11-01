package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;

/**
 * The FeedActivities Contract
 */
interface FeedActivitiesContract {

  interface Interactor extends IInteractor<Presenter> {
  }

  interface View extends PresentView<Presenter> {
    FragmentManager getFragmentManager();
  }

  interface Presenter extends IPresenter<View, Interactor> {
    PagerAdapter getFeedActivitiesAdapter();

    FeedActivitiesPresenter setFeed(Feed feed);
  }
}



