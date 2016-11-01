package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities;

import com.gemvietnam.base.viper.Interactor;

/**
 * The FeedActivities interactor
 */
class FeedActivitiesInteractor extends Interactor<FeedActivitiesContract.Presenter>
    implements FeedActivitiesContract.Interactor {

  FeedActivitiesInteractor(FeedActivitiesContract.Presenter presenter) {
    super(presenter);
  }
}
