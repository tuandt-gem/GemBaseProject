package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.likes;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

/**
 * The FeedLikes Presenter
 */
public class FeedLikesPresenter extends Presenter<FeedLikesContract.View, FeedLikesContract.Interactor>
    implements FeedLikesContract.Presenter {

  private Feed mFeed;

  public FeedLikesPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public FeedLikesContract.View onCreateView() {
    return FeedLikesFragment.getInstance();
  }

  @Override
  public void start() {
    // Start getting data here
    mView.setLikesCount(mFeed.getLikeCount());
  }

  @Override
  public FeedLikesContract.Interactor onCreateInteractor() {
    return new FeedLikesInteractor(this);
  }

  @Override
  public FeedLikesPresenter setFeed(Feed feed) {
    mFeed = feed;
    return this;
  }
}
