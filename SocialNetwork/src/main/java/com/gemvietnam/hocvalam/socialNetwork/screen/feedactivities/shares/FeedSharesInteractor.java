package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.shares;

import com.gemvietnam.base.viper.Interactor;

/**
 * The FeedShares interactor
 */
class FeedSharesInteractor extends Interactor<FeedSharesContract.Presenter>
    implements FeedSharesContract.Interactor {

  FeedSharesInteractor(FeedSharesContract.Presenter presenter) {
    super(presenter);
  }
}
