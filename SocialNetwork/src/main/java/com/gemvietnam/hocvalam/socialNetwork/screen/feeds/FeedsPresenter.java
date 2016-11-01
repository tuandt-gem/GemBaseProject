package com.gemvietnam.hocvalam.socialNetwork.screen.feeds;

import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.hocvalam.socialNetwork.data.remote.dto.Feed;
import com.gemvietnam.hocvalam.socialNetwork.screen.detail.DetailPresenter;
import com.gemvietnam.hocvalam.socialNetwork.screen.feedactivities.FeedActivitiesPresenter;
import com.gemvietnam.hocvalam.socialNetwork.screen.newpost.NewPostPresenter;

import java.util.List;

/**
 * Feeds Presenter
 * Created by neo on 7/19/2016.
 */
public class FeedsPresenter extends Presenter<FeedsContract.View, FeedsContract.Interactor>
    implements FeedsContract.Presenter {

  private List<Feed> mFeeds;
  private FeedAdapter mFeedAdapter;

  public FeedsPresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public FeedsContract.View onCreateView() {
    return FeedsFragment.getInstance();
  }

  @Override
  public void onFeedsLoaded(List<Feed> feeds) {
    mFeeds = feeds;
    mView.loadFeeds(getFeedAdapter());
  }

  @Override
  public void start() {
    mInteractor.getFeeds();
  }

  @Override
  public FeedsContract.Interactor onCreateInteractor() {
    return new FeedsInteractor(this);
  }

  public void viewDetail(Feed feed) {
    new DetailPresenter(mContainerView)
        .setFeed(feed)
        .pushView();
  }

  private void viewFeedActivities(Feed feed) {
    new FeedActivitiesPresenter(mContainerView)
        .setFeed(feed)
        .presentView();
  }

  public FeedAdapter getFeedAdapter() {
    if (mFeedAdapter == null) {
      mFeedAdapter = createFeedAdapter();
    }

    return mFeedAdapter;
  }

  /**
   * Create new instance of {@link FeedAdapter}
   */
  private FeedAdapter createFeedAdapter() {
    return new FeedAdapter(mView.getViewContext(), mFeeds)
        .setOnItemAction(mFeedAdapterListener);
  }

  @Override
  public void navigateNewPost() {
    new NewPostPresenter(mContainerView)
        .presentView();
  }

  /**
   * Feed items clicked listener
   */
  private FeedAdapter.OnItemAction mFeedAdapterListener = new FeedAdapter.OnItemAction() {
    @Override
    public void onItemClicked(Feed feed) {
      viewDetail(feed);
    }

    @Override
    public void onActivitiesLayoutClicked(Feed feed) {
      viewFeedActivities(feed);
    }
  };
}
