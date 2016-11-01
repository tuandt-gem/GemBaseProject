package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.comments;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

/**
 * The FeedComments Presenter
 */
public class FeedCommentsPresenter extends Presenter<FeedCommentsContract.View, FeedCommentsContract.Interactor>
    implements FeedCommentsContract.Presenter {
  private Feed mFeed;

  public FeedCommentsPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public FeedCommentsContract.View onCreateView() {
    return FeedCommentsFragment.getInstance();
  }

  @Override
  public void start() {
    // Start getting data here
    mView.setCommentsCount(mFeed.getCommentCount());
  }

  @Override
  public FeedCommentsContract.Interactor onCreateInteractor() {
    return new FeedCommentsInteractor(this);
  }

  @Override
  public FeedCommentsPresenter setFeed(Feed feed) {
    mFeed = feed;
    return this;
  }
}
