package com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;

import android.support.v4.view.PagerAdapter;

/**
 * The FeedActivities Presenter
 */
public class FeedActivitiesPresenter extends Presenter<FeedActivitiesContract.View, FeedActivitiesContract.Interactor>
    implements FeedActivitiesContract.Presenter {

  private FeedActivitiesAdapter mFeedActivitiesAdapter;
  private Feed mFeed;

  public FeedActivitiesPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public FeedActivitiesContract.View onCreateView() {
    return FeedActivitiesFragment.getInstance();
  }

  @Override
  public void start() {
    // Start getting data here
  }

  @Override
  public FeedActivitiesContract.Interactor onCreateInteractor() {
    return new FeedActivitiesInteractor(this);
  }

  @Override
  public PagerAdapter getFeedActivitiesAdapter() {
    if (mFeedActivitiesAdapter == null) {
      mFeedActivitiesAdapter = new FeedActivitiesAdapter(mView.getFragmentManager(), getViewContext(), mFeed);
    }

    return mFeedActivitiesAdapter;
  }

  @Override
  public FeedActivitiesPresenter setFeed(Feed feed) {
    mFeed = feed;
    return this;
  }
}
