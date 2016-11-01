package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.shares;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

/**
 * The FeedShares Presenter
 */
public class FeedSharesPresenter extends Presenter<FeedSharesContract.View, FeedSharesContract.Interactor>
    implements FeedSharesContract.Presenter {

  private Feed mFeed;

  public FeedSharesPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public FeedSharesContract.View onCreateView() {
    return FeedSharesFragment.getInstance();
  }

  @Override
  public void start() {
    // Start getting data here
    mView.setSharesCount(mFeed.getShareCount());
  }

  @Override
  public FeedSharesContract.Interactor onCreateInteractor() {
    return new FeedSharesInteractor(this);
  }

  @Override
  public FeedSharesPresenter setFeed(Feed feed) {
    mFeed = feed;
    return this;
  }
}
