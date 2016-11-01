package com.gemvietnam.hocvalam.socialNetwork.screen.detail;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

/**
 * The Detail Presenter
 */
public class DetailPresenter extends Presenter<DetailContract.View, DetailContract.Interactor>
    implements DetailContract.Presenter {

  private Feed mFeed;

  public DetailPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public DetailContract.View onCreateView() {
    return DetailFragment.getInstance();
  }

  @Override
  public void start() {
    mView.viewFeedDetail(mFeed);
  }

  @Override
  public DetailContract.Interactor onCreateInteractor() {
    return new DetailInteractor(this);
  }

  @Override
  public DetailPresenter setFeed(Feed feed) {
    mFeed = feed;
    return this;
  }
}
