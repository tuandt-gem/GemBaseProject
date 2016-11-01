package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.comments;

import com.gemvietnam.base.viper.Interactor;

/**
 * The FeedComments interactor
 */
class FeedCommentsInteractor extends Interactor<FeedCommentsContract.Presenter>
    implements FeedCommentsContract.Interactor {

  FeedCommentsInteractor(FeedCommentsContract.Presenter presenter) {
    super(presenter);
  }
}
