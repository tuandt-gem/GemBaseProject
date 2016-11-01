package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.likes;

import com.gemvietnam.base.viper.Interactor;

/**
 * The FeedLikes interactor
 */
class FeedLikesInteractor extends Interactor<FeedLikesContract.Presenter>
    implements FeedLikesContract.Interactor {

  FeedLikesInteractor(FeedLikesContract.Presenter presenter) {
    super(presenter);
  }
}
